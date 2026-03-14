package com.johndoe.application;

import java.awt.Component;

public class ComponentStats {
    protected final Component component;

    public ComponentStats(Component component) {
        this.component = component;
    }

    public int getSize() {
        return component.getWidth() * component.getHeight();
    }
}
