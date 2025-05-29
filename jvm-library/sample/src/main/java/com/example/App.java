package com.example;

import com.johndoe.library.ext.JLabelExtImpl;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

import static java.awt.Font.PLAIN;

final class App {
    private App() {}

    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setFont(new Font("Default", PLAIN, 20));
        label.setBounds(50, 50, 300, 100);

        JLabelExtImpl impl = new JLabelExtImpl(label);
        label.setText(String.format("%d pixels", impl.getSize()));
        label.setText(String.format("%s at %s", label.getText(), impl.getPosition()));

        JFrame frame = new JFrame();
        frame.add(label);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
