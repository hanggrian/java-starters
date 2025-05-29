package com.johndoe.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MyPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().register(
            "myTask",
            task -> {
                task.setDescription("Print a line");
                task.doLast(t ->
                    System.out.printf("%d characters%n", new ProjectImpl(project).getCount())
                );
            }
        );
    }
}
