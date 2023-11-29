package com.johndoe.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ViewTest {
  @Test
  public void test() {
    assertEquals("Hello World", new View().getText());
  }
}
