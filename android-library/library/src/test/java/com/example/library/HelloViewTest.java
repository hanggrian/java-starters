package com.example.library;

import static org.junit.Assert.assertEquals;

import androidx.appcompat.app.AppCompatActivity;
import com.example.library.test.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.internal.DoNotInstrument;

@RunWith(RobolectricTestRunner.class)
@DoNotInstrument
public class HelloViewTest {
  private AppCompatActivity activity;
  private HelloView view;

  @Before
  public void setup() {
    activity = Robolectric.buildActivity(TestActivity.class).setup().get();
    view = (HelloView) activity.getLayoutInflater().inflate(R.layout.activity_test, null);
  }

  @Test
  public void test() {
    assertEquals("Hello", view.getText().toString());
  }
}
