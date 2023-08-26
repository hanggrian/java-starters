val RELEASE_GROUP: String by project

plugins {
    java
    application
    checkstyle
    jacoco
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))

application.mainClass.set("$RELEASE_GROUP.app.App")

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = rootDir.resolve("rulebook_checks.xml")
}

dependencies {
    checkstyle(libs.checkstyle)
    checkstyle(libs.rulebook.checkstyle)

    testImplementation(libs.truth)
}
