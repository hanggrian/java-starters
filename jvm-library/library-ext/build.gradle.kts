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

    testImplementation(libs.truth)
}
