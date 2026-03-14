val releaseArtifact: String by project

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    checkstyle
}

android {
    namespace = "com.example"
    testNamespace = "$namespace.test"
    defaultConfig {
        applicationId = namespace
        multiDexEnabled = true
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.material)
    implementation(libs.androidx.core)
    implementation(libs.hilt)

    annotationProcessor(libs.hilt.compiler)
}
