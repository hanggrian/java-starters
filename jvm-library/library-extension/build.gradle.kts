val RELEASE_ARTIFACT: String by project

plugins {
    `java-library`
    checkstyle
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    checkstyle(libs.checkstyle)
    checkstyle(libs.rulebook.checkstyle)

    implementation(project(":$RELEASE_ARTIFACT"))

    testImplementation(libs.truth)
}
