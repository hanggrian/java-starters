package com.example;

import com.johndoe.library.ext.ExtendedComponentStats;
import java.awt.Component;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    @Inject public Provider<ExtendedComponentStats> statsProvider;
    private ExtendedComponentStats stats;

    public MainFrame(Component child) {
        add(child);
        setSize(400, 300);
        setLayout(null);
        setVisible(true);
    }

    public ExtendedComponentStats getStats() {
        if (stats == null) {
            stats = statsProvider.get();
        }
        return stats;
    }
}
