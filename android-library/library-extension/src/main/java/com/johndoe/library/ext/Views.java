package com.johndoe.library.ext;

import android.content.Context;
import com.johndoe.library.View;

public final class Views {
    private Views() {}

    public static View create(Context context) {
        return new View(context);
    }
}
