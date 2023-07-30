import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

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

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
    pom(::configurePom)
    configure(AndroidSingleVariantLibrary())
}

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = rootDir.resolve("rulebook_checks.xml")
}

dependencies {
    checkstyle(libs.checkstyle)
    checkstyle(libs.rulebook.checkstyle)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.bundles.androidx.test)
}
