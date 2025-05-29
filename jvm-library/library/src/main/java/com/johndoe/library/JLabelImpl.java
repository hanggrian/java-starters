package com.johndoe.library;

import javax.swing.JLabel;

public class JLabelImpl {
    protected final JLabel label;

    public JLabelImpl(JLabel label) {
        this.label = label;
    }

    public int getSize() {
        return label.getWidth() * label.getHeight();
    }
}
