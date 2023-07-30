plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example"
    testNamespace = "$namespace.test"
    defaultConfig {
        applicationId = namespace
        multiDexEnabled = true
    }
    lint.abortOnError = false
}

dependencies {
    api(project(":$RELEASE_ARTIFACT"))
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)
}
