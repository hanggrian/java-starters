val releaseGroup: String by project

plugins {
    java
    application
    checkstyle
    jacoco
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))

application.mainClass.set("$releaseGroup.app.App")

checkstyle.toolVersion = libs.versions.checkstyle.get()

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    testImplementation(libs.truth)
}
