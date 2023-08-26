import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

val RELEASE_GROUP: String by project
val RELEASE_ARTIFACT: String by project

plugins {
    alias(libs.plugins.android.library)
    checkstyle
    jacoco
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
    testNamespace = "$namespace.test"
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    checkstyle(libs.checkstyle)
    checkstyle(libs.rulebook.checkstyle)

    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(libs.androidx.appcompat)

    testImplementation(libs.bundles.androidx.test)
}
