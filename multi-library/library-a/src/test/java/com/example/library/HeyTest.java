package com.example.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeyTest {
  @Test
  public void test() {
    assertEquals("hey!", new Hey().toString());
  }
}
