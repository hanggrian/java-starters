package com.johndoe.library.ext;

import com.johndoe.library.JLabelImpl;
import javax.swing.JLabel;

public class JLabelExtImpl extends JLabelImpl {
    public JLabelExtImpl(JLabel label) {
        super(label);
    }

    public String getPosition() {
        return String.format("(%d,%d)", label.getX(), label.getY());
    }
}
