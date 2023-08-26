package com.example.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
  @Test
  public void test() {
    assertEquals(0, new App().hashCode());
  }
}
