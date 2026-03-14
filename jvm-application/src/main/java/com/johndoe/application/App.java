package com.johndoe.application;

import java.awt.Font;
import javax.swing.JLabel;

public final class App {
    private App() {}

    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setFont(new Font("Default", Font.PLAIN, 20));

        MainFrame frame = new MainFrame(label);
        frame.setTitle("My Application");
        label.setText(frame.getStats().getSize() + " pixels");
    }
}
