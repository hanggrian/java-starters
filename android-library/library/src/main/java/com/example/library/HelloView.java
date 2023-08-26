package com.example.library;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class HelloView extends AppCompatTextView {
  public HelloView(@NonNull Context context) {
    super(context);
  }

  public HelloView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public HelloView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  public CharSequence getText() {
    return "Hello";
  }
}
