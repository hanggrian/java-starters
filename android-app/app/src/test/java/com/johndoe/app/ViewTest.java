package com.johndoe.app;

import static org.junit.Assert.assertEquals;

import androidx.appcompat.app.AppCompatActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.internal.DoNotInstrument;

@RunWith(RobolectricTestRunner.class)
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
        assertEquals("Hello World", view.getText());
    }
}
