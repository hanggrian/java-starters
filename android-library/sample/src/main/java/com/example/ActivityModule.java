package com.example;

import android.app.Activity;
import android.view.View;
import com.johndoe.library.ext.ExtendedViewStats;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {
    @Provides
    public ExtendedViewStats provideStats(@Stats View view) {
        return new ExtendedViewStats(view);
    }

    @Provides
    @Stats
    public View provideView(Activity activity) {
        return activity.findViewById(R.id.text);
    }
}
