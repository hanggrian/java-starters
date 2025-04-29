package com.johndoe.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MyPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().register("myTask").configure(task -> {
            task.setDescription("Print a line");
            task.doLast(t -> System.out.println("line"));
        });
    }
}
