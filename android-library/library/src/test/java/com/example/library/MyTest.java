package com.example.library;

import static org.junit.Assert.assertEquals;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.internal.DoNotInstrument;

import com.example.library.test.R;

@RunWith(RobolectricTestRunner.class)
@DoNotInstrument
public class MyTest {
  private AppCompatActivity activity;
  private EditText editText;

  @Before
  public void setup() {
    activity = Robolectric.buildActivity(MyTestActivity.class).setup().get();
    editText = (EditText) activity.getLayoutInflater().inflate(R.layout.test_edittext, null);
  }

  @Test
  public void test() {
    editText.setText("Hello world");
    assertEquals("Hello world", editText.getText().toString());
  }
}
