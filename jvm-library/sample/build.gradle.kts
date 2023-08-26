val RELEASE_ARTIFACT: String by project

plugins {
    java
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(project(":$RELEASE_ARTIFACT-extension"))
}
