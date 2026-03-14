package com.johndoe.plugin;

import static com.google.common.truth.Truth.assertThat;
import static org.gradle.testkit.runner.TaskOutcome.SUCCESS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class MyPluginTest {
    @Rule public final TemporaryFolder testProjectDir = new TemporaryFolder();
    private File buildFile;
    private GradleRunner runner;

    @Before
    public void setup() {
        try (Writer writer =
                 new BufferedWriter(
                     new OutputStreamWriter(
                         Files.newOutputStream(
                             testProjectDir.newFile("settings.gradle.kts").toPath()
                         ),
                         StandardCharsets.UTF_8
                     )
                 )
        ) {
            writer.write("rootProject.name = \"functional-test\"");

            buildFile = testProjectDir.newFile("build.gradle.kts");
            runner =
                GradleRunner
                    .create()
                    .withPluginClasspath()
                    .withProjectDir(testProjectDir.getRoot())
                    .withTestKitDir(testProjectDir.newFolder());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myTask() {
        try (Writer writer =
                 new BufferedWriter(
                     new OutputStreamWriter(
                         Files.newOutputStream(buildFile.toPath()),
                         StandardCharsets.UTF_8
                     )
                 )
        ) {
            writer.write(
                "plugins {" +
                    "    id(\"com.johndoe.plugin\")" +
                    "}"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(
            Objects
                .requireNonNull(
                    runner
                        .withArguments("myTask")
                        .build()
                        .task(":myTask")
                ).getOutcome()
        ).isEqualTo(SUCCESS);
    }
}
