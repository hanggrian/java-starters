val DEVELOPER_ID: String by project
val DEVELOPER_NAME: String by project
val DEVELOPER_URL: String by project
val RELEASE_GROUP: String by project
val RELEASE_ARTIFACT: String by project
val RELEASE_VERSION: String by project
val RELEASE_DESCRIPTION: String by project
val RELEASE_URL: String by project

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
}

subprojects {
    plugins.withType<com.android.build.gradle.LibraryPlugin>().configureEach {
        modify(the<com.android.build.gradle.LibraryExtension>())
    }
    plugins.withType<com.android.build.gradle.AppPlugin>().configureEach {
        modify(the<com.android.build.gradle.internal.dsl.BaseAppModuleExtension>())
    }
    plugins.withType<CheckstylePlugin>().configureEach {
        configure<CheckstyleExtension> {
            toolVersion = libs.versions.checkstyle.get()
            configFile = rootDir.resolve("rulebook_checks.xml")
        }
        // only in Android, checkstyle task need to be manually defined
        tasks.register<Checkstyle>("checkstyle") {
            group = LifecycleBasePlugin.VERIFICATION_GROUP
            source("src")
            include("**/*.java")
            exclude("**/gen/**", "**/R.java")
            classpath = files()
        }
    }
    plugins.withType<com.vanniktech.maven.publish.MavenPublishBasePlugin> {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            configure(com.vanniktech.maven.publish.AndroidSingleVariantLibrary())
            publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.Companion.S01)
            signAllPublications()
            pom {
                name.set(project.name)
                description.set(RELEASE_DESCRIPTION)
                url.set(RELEASE_URL)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(DEVELOPER_ID)
                        name.set(DEVELOPER_NAME)
                        url.set(DEVELOPER_URL)
                    }
                }
                scm {
                    url.set(RELEASE_URL)
                    connection.set("scm:git:https://github.com/$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
                    developerConnection.set("scm:git:ssh://git@github.com/$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
                }
            }
        }
    }
}

fun modify(extension: com.android.build.gradle.BaseExtension) {
    extension.setCompileSdkVersion(libs.versions.sdk.target.get().toInt())
    extension.defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    extension.compileOptions {
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
}
