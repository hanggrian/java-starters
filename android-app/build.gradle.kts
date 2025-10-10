val releaseGroup: String by project
val releaseVersion: String by project
val releaseArtifact: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaLanguageVersion.of(libs.versions.java.support.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    kotlin("android") version "2.1.0"
    alias(libs.plugins.android.application)
    checkstyle
    jacoco
}

java.toolchain.languageVersion.set(javaCompileVersion)

android {
    namespace = "$releaseGroup.$releaseArtifact"
    testNamespace = "$namespace.test"
    compileSdk = libs.versions.android.compile.get().toInt()
    defaultConfig {
        targetSdk = libs.versions.android.compile.get().toInt()
        minSdk = libs.versions.android.support.get().toInt()
        version = releaseVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = namespace
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(javaSupportVersion)
        targetCompatibility = JavaVersion.toVersion(javaSupportVersion)
    }
    testOptions.unitTests.isIncludeAndroidResources = true
    buildTypes {
        debug {
            enableAndroidTestCoverage = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configProperties =
        mapOf(
            "checkstyle.suppressions.file" to
                "$rootDir/config/checkstyle/suppressions.xml",
        )
}

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(libs.material)
    implementation(libs.androidx.core)
    implementation(libs.androidx.multidex)

    testImplementation(libs.bundles.junit4)
}

tasks {
    val checkstyleAndroid by registering(Checkstyle::class) {
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        description = "Generate Android lint report"

        source("src")
        include("**/*.java")
        exclude("**/gen/**", "**/R.java")
        classpath = files()
    }
    check {
        dependsOn(checkstyleAndroid)
    }

    withType<Test>().configureEach {
        configure<JacocoTaskExtension> {
            isIncludeNoLocationClasses = true
            excludes = listOf("jdk.internal.*")
        }
    }
    register<JacocoReport>("jacocoAndroid") {
        group = "Reporting"
        description = "Generate Android test coverage"

        dependsOn("testDebugUnitTest", "connectedDebugAndroidTest")
        mustRunAfter("test")
        reports {
            xml.required.set(true)
            html.required.set(true)
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
