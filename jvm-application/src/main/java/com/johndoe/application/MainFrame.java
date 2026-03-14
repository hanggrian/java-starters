package com.johndoe.application;

import java.awt.Component;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    @Inject public Provider<ComponentStats> statsProvider;
    private ComponentStats stats;

    public MainFrame(Component child) {
        add(child);
        setSize(400, 300);
        setVisible(true);
    }

    public ComponentStats getStats() {
        if (stats == null) {
            stats = statsProvider.get();
        }
        return stats;
    }
}
