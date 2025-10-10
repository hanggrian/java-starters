val developerId: String by project
val releaseArtifact: String by project
val releaseGroup: String by project
val releaseDescription: String by project
val releaseUrl: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaLanguageVersion.of(libs.versions.java.support.get())

plugins {
    java
    checkstyle
    alias(libs.plugins.gradle.publish)
}

java.toolchain.languageVersion.set(javaCompileVersion)

checkstyle.toolVersion = libs.versions.checkstyle.get()

gradlePlugin {
    website.set(releaseUrl)
    vcsUrl.set("https://github.com/$developerId/$releaseArtifact.git")
    plugins.register("myPlugin") {
        id = "$releaseGroup.$releaseArtifact"
        implementationClass = "$releaseGroup.$releaseArtifact.MyPlugin"
        displayName = "My Plugin"
        description = releaseDescription
        tags.set(listOf("first-tag", "second-tag"))
    }
    testSourceSets(sourceSets.test.get())
}

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    compileOnly(gradleApi())

    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.junit4)
}

tasks {
    compileJava {
        options.release = javaSupportVersion.asInt()
    }
    javadoc {
        setDestinationDir(layout.buildDirectory.dir("docs/${project.name}").get().asFile)
    }
}
