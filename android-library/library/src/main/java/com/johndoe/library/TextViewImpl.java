package com.johndoe.library;

import android.widget.TextView;

public class TextViewImpl {
    protected final TextView text;

    public TextViewImpl(TextView text) {
        this.text = text;
    }

    public int getSize() {
        return text.getWidth() * text.getHeight();
    }
}
