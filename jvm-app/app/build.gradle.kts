val releaseGroup: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

plugins {
    java
    application
    checkstyle
    jacoco
}

java.toolchain.languageVersion.set(jdkVersion)

application.mainClass.set("$releaseGroup.app.App")

checkstyle.toolVersion = libs.versions.checkstyle.get()

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    testImplementation(libs.truth)
}

tasks.compileJava {
    options.release = jreVersion.asInt()
}
