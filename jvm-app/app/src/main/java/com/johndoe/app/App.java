package com.johndoe.app;

import javax.swing.JFrame;

public final class App {
    private App() {}

    public static void main(String[] args) {
        View view = new View();
        view.setBounds(10, 10, 100, 40);

        JFrame frame = new JFrame();
        frame.add(view);
        frame.setSize(100, 100);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
