package com.johndoe.application;

import android.app.Activity;
import android.view.View;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {
    @Provides
    public ViewStats provideStats(@Stats View view) {
        return new ViewStats(view);
    }

    @Provides
    @Stats
    public View provideView(Activity activity) {
        return activity.findViewById(R.id.text);
    }
}
