package com.johndoe.app;

import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.internal.DoNotInstrument;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP)
@DoNotInstrument
public class ViewTest {
    private AppCompatActivity activity;
    private View view;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(TestActivity.class).setup().get();
        view = (View) activity.getLayoutInflater().inflate(R.layout.activity_main, null);
    }

    @Test
    public void test() {
        assertEquals(activity.getString(android.R.string.ok), view.getText());
    }
}
