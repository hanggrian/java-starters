package com.johndoe.app;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);

        TextView text = new TextView(this);
        text.setX(50);
        text.setY(50);
        text.setWidth(300);
        text.setHeight(100);

        text.setText(
            String.format(Locale.getDefault(), "%d pixels", new TextViewImpl(text).getSize())
        );

        layout.addView(text);
    }
}
