val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project

plugins {
    alias(libs.plugins.android.application)
    checkstyle
    jacoco
}

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

java.toolchain.languageVersion.set(jdkVersion)

android {
    namespace = "$releaseGroup.$releaseArtifact"
    testNamespace = "$namespace.test"
    compileSdk = libs.versions.sdk.target.get().toInt()
    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        version = releaseVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = namespace
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(jreVersion)
        targetCompatibility = JavaVersion.toVersion(jreVersion)
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

checkstyle.toolVersion = libs.versions.checkstyle.get()

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)

    testImplementation(libs.bundles.androidx.test)
}

tasks.register<Checkstyle>("checkstyle") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    source("src")
    include("**/*.java")
    exclude("**/gen/**", "**/R.java")
    classpath = files()
}
