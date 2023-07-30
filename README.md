# Java Starters

Personal Gradle project templates with emphasis on **Java**, separated by target
platform and kind of distribution.

Components included in each template:

- GitHub project layout:
  - [README](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes/)
    and [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository/)
    file in root directory.
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    scripts with `buildSrc` containing project helpers.
  - Apply plugin using [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html).
  - [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html)
    in TOML file to avoid typing unsafe dependencies.
- Java-specific:
  - [JaCoCo](https://docs.gradle.org/current/userguide/jacoco_plugin.html) code
    coverage.
- Test dependencies:
  - [Google Truth](https://github.com/google/truth/) assertion tool.
- Code styling:
  - [EditorConfig](https://editorconfig.org/) root file.
  - [CheckStyle](https://checkstyle.sourceforge.io/) code linter with custom
    rules [Rulebook](https://github.com/hendraanggrian/rulebook/).
- Website module:
  - [Pages Gradle Plugin](https://github.com/hendraanggrian/pages-gradle-plugin/)
    for generating webpage displaying README's content and documentation links
    (except for apps).
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).
- Third-party services:
  - [Travis CI](https://travis-ci.com/) to run test every commit.
  - [Codecov](https://about.codecov.io/) integration within Travis CI, except
    for `gradle-plugin`.

Situational components differ by target:

| | Plugins | Publications | Tests |
| --- | --- | --- | --- |
| android-app | [Android] | | [Robolectric] |
| android-library | [Android] | [Maven Central] | [Robolectric] |
| jvm-app | [Application] | | |
| jvm-library | | [Maven Central] | |
| multi-library | | [Maven Central] | |

[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build/
[Maven Central]: https://search.maven.org/
[Robolectric]: http://robolectric.org/
