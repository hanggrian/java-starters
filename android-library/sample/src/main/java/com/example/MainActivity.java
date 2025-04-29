package com.example;

import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.johndoe.library.ext.Views;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((RelativeLayout) findViewById(R.id.layout)).addView(Views.create(this));
    }
}
