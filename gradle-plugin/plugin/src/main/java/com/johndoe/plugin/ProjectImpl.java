package com.johndoe.plugin;

import org.gradle.api.Project;

public class ProjectImpl {
    protected final Project project;

    public ProjectImpl(Project project) {
        this.project = project;
    }

    public int getCount() {
        return project.getName().length();
    }
}
