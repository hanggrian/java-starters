package com.johndoe.application;

import dagger.Module;
import dagger.Provides;
import java.awt.Component;

@Module
public class FrameModule {
    @Provides
    public ComponentStats provideStats(@Stats Component component) {
        return new ComponentStats(component);
    }

    @Provides
    @Stats
    public Component provideView(MainFrame frame) {
        return frame.getComponent(0);
    }
}
