val releaseArtifact: String by project

plugins {
    java
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-ext"))
}
