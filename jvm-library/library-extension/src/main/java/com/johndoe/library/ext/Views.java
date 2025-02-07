package com.johndoe.library.ext;

import com.johndoe.library.View;

public final class Views {
    private Views() {}

    public static View create() {
        View view = new View();
        view.setBounds(10, 10, 100, 40);
        return view;
    }
}
