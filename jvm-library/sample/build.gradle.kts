val releaseArtifact: String by project

plugins {
    java
    checkstyle
    application
}

application.mainClass.set("com.example.App")

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.dagger)

    annotationProcessor(libs.dagger.compiler)
}
