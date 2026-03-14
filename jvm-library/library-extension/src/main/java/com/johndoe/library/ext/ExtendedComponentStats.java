package com.johndoe.library.ext;

import com.johndoe.library.ComponentStats;
import java.awt.Component;

public class ExtendedComponentStats extends ComponentStats {
    public ExtendedComponentStats(Component component) {
        super(component);
    }

    public String getPosition() {
        return "(" + component.getX() + "," + component.getY() + ")";
    }
}
