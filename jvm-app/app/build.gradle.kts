plugins {
    java
    application
    checkstyle
    jacoco
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = projectDir.resolve("rulebook_checks.xml")
}

dependencies {
    checkstyle(libs.checkstyle)
    checkstyle(libs.rulebook.checkstyle)
    testImplementation(libs.truth)
}
