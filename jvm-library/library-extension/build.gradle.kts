val releaseArtifact: String by project

plugins {
    `java-library`
    checkstyle
    jacoco
    alias(libs.plugins.maven.publish)
}

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(project(":$releaseArtifact"))

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.truth)

    testRuntimeOnly(libs.junit.platform.launcher)
}
