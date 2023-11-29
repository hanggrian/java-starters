package com.example;

import com.johndoe.library.Views;
import javax.swing.JFrame;

public class App {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.add(Views.create());
    frame.setSize(100, 100);
    frame.setLayout(null);
    frame.setVisible(true);
  }
}
