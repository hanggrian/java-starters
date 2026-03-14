package com.johndoe.library.ext;

import android.view.View;
import com.johndoe.library.ViewStats;

public class ExtendedViewStats extends ViewStats {
    public ExtendedViewStats(View view) {
        super(view);
    }

    public String getPosition() {
        return "(" + (int) view.getX() + "," + (int) view.getY() + ")";
    }
}
