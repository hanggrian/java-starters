package com.example.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldTest {
  @Test
  public void test() {
    assertEquals("Hello World", new HelloWorld().toString());
  }
}
