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
public class HelloWorldViewTest {
  private AppCompatActivity activity;
  private HelloWorldView view;

  @Before
  public void setup() {
    activity = Robolectric.buildActivity(TestActivity.class).setup().get();
    view = (HelloWorldView) activity.getLayoutInflater().inflate(R.layout.activity_test, null);
  }

  @Test
  public void test() {
    assertEquals("Hello World", view.getText().toString());
  }
}
