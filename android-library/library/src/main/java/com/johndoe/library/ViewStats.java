package com.johndoe.library;

import android.view.View;

public class ViewStats {
    protected final View view;

    public ViewStats(View view) {
        this.view = view;
    }

    public int getSize() {
        return view.getWidth() * view.getHeight();
    }
}
