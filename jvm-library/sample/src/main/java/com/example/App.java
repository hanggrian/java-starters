package com.example;

import java.awt.Font;
import javax.swing.JLabel;

public final class App {
    private App() {}

    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setFont(new Font("Default", Font.PLAIN, 20));
        label.setBounds(50, 50, 300, 100);

        MainFrame frame = new MainFrame(label);
        label.setText(frame.getStats().getSize() + " pixels at " + frame.getStats().getPosition());
    }
}
