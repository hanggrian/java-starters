package com.johndoe.library;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class View extends AppCompatTextView {
    public View(@NonNull Context context) {
        super(context);
        setText(android.R.string.ok);
    }

    public View(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setText(android.R.string.ok);
    }

    public View(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setText(android.R.string.ok);
    }
}
