package com.johndoe.library.ext;

import android.widget.TextView;
import com.johndoe.library.TextViewImpl;
import java.util.Locale;

public class TextViewExtImpl extends TextViewImpl {
    public TextViewExtImpl(TextView text) {
        super(text);
    }

    public String getPosition() {
        return String.format(Locale.getDefault(), "(%.0f,%.0f)", text.getX(), text.getY());
    }
}
