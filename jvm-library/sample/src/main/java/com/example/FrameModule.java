package com.example;

import com.johndoe.library.ext.ExtendedComponentStats;
import dagger.Module;
import dagger.Provides;
import java.awt.Component;

@Module
public class FrameModule {
    @Provides
    public ExtendedComponentStats provideStats(@Stats Component component) {
        return new ExtendedComponentStats(component);
    }

    @Provides
    @Stats
    public Component provideView(MainFrame frame) {
        return frame.getComponent(0);
    }
}
