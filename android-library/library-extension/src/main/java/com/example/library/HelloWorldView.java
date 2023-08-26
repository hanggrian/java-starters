package com.example.library;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HelloWorldView extends HelloView {
  public HelloWorldView(@NonNull Context context) {
    super(context);
  }

  public HelloWorldView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public HelloWorldView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  public CharSequence getText() {
    return super.getText() + " World";
  }
}
