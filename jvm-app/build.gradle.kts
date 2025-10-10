val releaseGroup: String by project
val releaseVersion: String by project
val releaseArtifact: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaLanguageVersion.of(libs.versions.java.support.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    java
    application
    checkstyle
    jacoco
}

java.toolchain.languageVersion.set(javaCompileVersion)

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

checkstyle.toolVersion = libs.versions.checkstyle.get()

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks {
    compileJava {
        options.release = javaSupportVersion.asInt()
    }
    test {
        useJUnitPlatform()
    }
    jacocoTestReport {
        reports.xml.required = true
    }
}
