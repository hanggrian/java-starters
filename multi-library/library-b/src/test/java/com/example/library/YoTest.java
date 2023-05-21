package com.example.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YoTest {
  @Test
  public void test() {
    assertEquals("yo!", new Yo().toString());
  }
}
