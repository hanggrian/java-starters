package com.example.app;

import static org.junit.Assert.assertEquals;

import android.widget.EditText;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.internal.DoNotInstrument;

@RunWith(RobolectricTestRunner.class)
@DoNotInstrument
public class MyTest {
  private MainActivity activity;
  private EditText editText;

  @Before
  public void setup() {
    activity = Robolectric.buildActivity(MainActivity.class).setup().get();
    editText = activity.findViewById(R.id.editText);
  }

  @Test
  public void test() {
    editText.setText("Hello world");
    assertEquals("Hello world", editText.getText().toString());
  }
}
