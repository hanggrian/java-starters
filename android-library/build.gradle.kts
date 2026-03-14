import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin

val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaVersion.toVersion(libs.versions.java.support.get())

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = releaseGroup
    version = releaseVersion
}

subprojects {
    plugins.withType<LibraryPlugin>().configureEach {
        modify(the<LibraryExtension>())
        configure<LibraryAndroidComponentsExtension> {
            onVariants { variant ->
                val taskName = "javadocAndroid${variant.name.replaceFirstChar { it.uppercase() }}"
                tasks.register<Javadoc>(taskName) {
                    description = "Generates Javadoc for ${variant.name}."
                    group = "documentation"

                    destinationDir = layout.buildDirectory.dir("docs/${project.name}/").get().asFile

                    variant.sources.java?.all?.let { source(it) }
                    classpath =
                        configurations
                            .getByName("${variant.name}CompileClasspath")
                            .incoming
                            .artifactView {
                                attributes {
                                    attribute(
                                        Attribute.of("artifactType", String::class.java),
                                        "android-classes-jar"
                                    )
                                }
                            }.files +
                            files(sdkComponents.bootClasspath)
                    options {
                        encoding = "UTF-8"
                        (this as StandardJavadocDocletOptions).apply {
                            links("https://developer.android.com/reference")
                            addStringOption("Xdoclint:none", "-quiet")
                        }
                    }
                    isFailOnError = false
                    exclude("**/BuildConfig.java", "**/R.java")
                }
            }
        }
    }
    plugins.withType<AppPlugin>().configureEach {
        modify(the<ApplicationExtension>())
    }
    plugins.withType<JavaBasePlugin>().configureEach {
        the<JavaPluginExtension>().toolchain.languageVersion.set(javaCompileVersion)
    }
    plugins.withType<CheckstylePlugin>().configureEach {
        the<CheckstyleExtension>().toolVersion = libs.versions.checkstyle.get()
        tasks {
            val checkstyleAndroid by registering(Checkstyle::class) {
                group = LifecycleBasePlugin.VERIFICATION_GROUP
                description = "Generate Android lint report"

                source("src")
                include("**/*.java")
                exclude("**/gen/**", "**/R.java")
                classpath = files()
            }
            named("check") {
                dependsOn(checkstyleAndroid)
            }
        }
    }
    plugins.withType<JacocoPlugin>().configureEach {
        tasks {
            withType<Test>().configureEach {
                configure<JacocoTaskExtension> {
                    isIncludeNoLocationClasses = true
                    excludes = listOf("jdk.internal.*")
                }
            }
            register<JacocoReport>("jacocoAndroid") {
                group = "Reporting"
                description = "Generate Android test coverage"

                dependsOn("testDebugUnitTest")
                mustRunAfter("test")
                reports {
                    xml.required.set(true)
                }
                sourceDirectories.setFrom(layout.projectDirectory.dir("src/main/java"))
                classDirectories.setFrom(
                    files(
                        fileTree(layout.buildDirectory.dir("intermediates/javac/")) {
                            exclude(
                                "**/R.class",
                                "**/R\$*.class",
                                "**/BuildConfig.*",
                                "**/Manifest*.*",
                                "**/*Test*.*",
                                "**/*Args.*",
                                "**/*Directions.*",
                            )
                        },
                    ),
                )
                executionData.setFrom(
                    files(
                        fileTree(layout.buildDirectory) {
                            include("**/*.exec", "**/*.ec")
                        },
                    ),
                )
            }
        }
    }
    plugins.withType<MavenPublishBasePlugin> {
        configure<MavenPublishBaseExtension> {
            configure(AndroidSingleVariantLibrary())
            publishToMavenCentral()
            signAllPublications()
            pom {
                name.set(project.name)
                description.set(releaseDescription)
                url.set(releaseUrl)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(developerId)
                        name.set(developerName)
                        url.set(developerUrl)
                    }
                }
                scm {
                    url.set(releaseUrl)
                    connection.set("scm:git:https://github.com/$developerId/$releaseArtifact.git")
                    developerConnection
                        .set("scm:git:ssh://git@github.com/$developerId/$releaseArtifact.git")
                }
            }
        }
    }
}

fun modify(extension: CommonExtension) {
    extension.compileSdk = libs.versions.android.compile.get().toInt()
    extension.defaultConfig.run {
        minSdk = libs.versions.android.support.get().toInt()
        version = releaseVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    extension.compileOptions.run {
        sourceCompatibility = javaSupportVersion
        targetCompatibility = javaSupportVersion
    }
}
