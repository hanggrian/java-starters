package com.johndoe.library;

public final class Views {
    private Views() {}

    public static View create() {
        View view = new View();
        view.setBounds(10, 10, 100, 40);
        return view;
    }
}
