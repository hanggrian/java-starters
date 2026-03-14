package com.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.databinding.ActivityMainBinding;
import com.johndoe.library.ext.ExtendedViewStats;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import javax.inject.Provider;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Inject
    public Provider<ExtendedViewStats> statsProvider;
    private ExtendedViewStats stats;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.text.setText(getStats().getSize() + " pixels at " + getStats().getPosition());
    }

    public ExtendedViewStats getStats() {
        if (stats == null) {
            stats = statsProvider.get();
        }
        return stats;
    }
}
