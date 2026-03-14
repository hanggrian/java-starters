package com.johndoe.library.ext;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.internal.DoNotInstrument;

@RunWith(RobolectricTestRunner.class)
@DoNotInstrument
public class ExtendedViewStatsTest {
    @Mock private View view;
    private AutoCloseable mocks;
    private AppCompatActivity activity;

    @Before
    public void setup() {
        mocks = MockitoAnnotations.openMocks(this);
        try (ActivityController<TestActivity> controller =
                 Robolectric.buildActivity(TestActivity.class)) {
            activity = controller.setup().get();
        }
    }

    @After
    public void cleanup() {
        try {
            mocks.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        when(view.getX()).thenReturn(0f);
        when(view.getY()).thenReturn(1f);
        assertThat(new ExtendedViewStats(view).getPosition()).isEqualTo("(0,1)");
        verify(view).getX();
        verify(view).getY();
    }
}
