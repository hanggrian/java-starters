package com.johndoe.library.ext;

import android.os.Build;
import android.widget.TextView;
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
import org.robolectric.annotation.Config;
import org.robolectric.annotation.internal.DoNotInstrument;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP)
@DoNotInstrument
public class TextViewExtImplTest {
    @Mock private TextView text;

    private AutoCloseable mocks;
    private AppCompatActivity activity;

    @Before
    public void setup() {
        mocks = MockitoAnnotations.openMocks(this);
        try (ActivityController<TestActivity> controller =
                 Robolectric.buildActivity(TestActivity.class)
        ) {
            activity = controller.setup().get();
        }
    }

    @Test
    public void test() {
        when(text.getX()).thenReturn(0f);
        when(text.getY()).thenReturn(1f);
        assertThat(new TextViewExtImpl(text).getPosition()).isEqualTo("(0,1)");
        verify(text).getX();
        verify(text).getY();
    }

    @After
    public void cleanup() throws Exception {
        mocks.close();
    }
}
