# Java Starters

![Logo](https://github.com/hanggrian/java-starters/raw/assets/logo.png)

Common Gradle project templates with emphasis on **Java,** separated by target
platform and kind of distribution.

| | Plugins | Testing | Publishing | Website | Coverage | Max Heap Size
--- | :---: | :---: | :---: | :---: | :---: | :---:
android-application | [Android] | [JUnit 4], [Robolectric] | &cross; | [Cayman] | &check; | 4GB
android-library | [Android] | [JUnit 4], [Robolectric] | [Maven Central] | [Javadoc], [Minimal] | &check; | 4GB
gradle-plugin | [Java] | [JUnit 4] | [Plugin Portal] | [Javadoc], [Minimal] | &cross; | 2GB
jvm-application | [Java], [Application] | [JUnit 5] | &cross; | [Cayman] | &check; | 2GB
jvm-library | [Java Library] | [JUnit 5] | [Maven Central] | [Javadoc], [Minimal] | &check; | 2GB

## Frameworks

- JUnit testing framework with [Mockito](https://site.mockito.org/) suite and
  [Truth](https://truth.dev/) asserter.
- [Checkstyle](https://checkstyle.sourceforge.io/) code linter with third-party
  ruleset [Rulebook](https://github.com/hendraanggrian/rulebook/).
- [JaCoCo](https://docs.gradle.org/current/userguide/jacoco_plugin.html) code
  coverage.

## Project layout

- GitHub project layout:
  - GitHub [README](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes/),
    [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository/),
    and [gitignore](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files/)
    file.
  - [EditorConfig](https://editorconfig.org/) enforces IDE settings.
- [CircleCI](https://circleci.com/) workflow:
  - Run tests, linters and push coverage to [Codecov](https://codecov.io/).
  - Activate [Renovate](https://docs.renovatebot.com/) bot to alert out-of-date
    dependencies.
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    scripts with properties delegation.
  - Apply plugin using [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html).
  - [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html)
    in TOML file to avoid typing unsafe dependencies.
- Website module:
  - [Pages Gradle Plugin](https://github.com/hendraanggrian/pages-gradle-plugin/)
    for generating webpage displaying README's content and documentation links.
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).

[Java]: https://docs.gradle.org/current/userguide/java_plugin.html
[Java Library]: https://docs.gradle.org/current/userguide/java_library_plugin.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build/
[JUnit 4]: https://junit.org/junit4/
[JUnit 5]: https://junit.org/junit5/
[Robolectric]: https://robolectric.org/
[Plugin Portal]: https://plugins.gradle.org/
[Maven Central]: https://central.sonatype.com/
[Javadoc]: https://docs.gradle.org/current/dsl/org.gradle.api.tasks.javadoc.Javadoc.html
[Cayman]: https://hanggrian.github.io/cayman-dark-theme/
[Minimal]: https://hanggrian.github.io/minimal-dark-theme/
