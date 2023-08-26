package com.example.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {
  @Test
  public void test() {
    assertEquals("Hello", new Hello().toString());
  }
}
