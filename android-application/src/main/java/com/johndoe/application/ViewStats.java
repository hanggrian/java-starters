package com.johndoe.application;

import android.view.View;

public class ViewStats {
    private final View view;

    public ViewStats(View view) {
        this.view = view;
    }

    public int getSize() {
        return view.getWidth() * view.getHeight();
    }

    public View getView() {
        return view;
    }
}
