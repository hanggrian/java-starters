package com.johndoe.library;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ViewsTest {
  @Test
  public void test() {
    assertNotNull(Views.create());
  }
}
