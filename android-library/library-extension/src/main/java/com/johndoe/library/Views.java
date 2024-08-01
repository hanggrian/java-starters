package com.johndoe.library;

import android.content.Context;

public final class Views {
    private Views() {}

    public static View create(Context context) {
    return new View(context);
    }
}
