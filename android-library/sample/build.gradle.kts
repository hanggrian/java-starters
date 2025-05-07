val releaseArtifact: String by project

plugins {
    kotlin("android") version "2.1.0"
    alias(libs.plugins.android.application)
    checkstyle
}

android {
    namespace = "com.example"
    testNamespace = "$namespace.test"
    defaultConfig {
        applicationId = namespace
        multiDexEnabled = true
    }
}

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.material)
    implementation(libs.androidx.core)
    implementation(libs.androidx.multidex)
}
