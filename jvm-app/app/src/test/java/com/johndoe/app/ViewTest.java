package com.johndoe.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViewTest {
    @Test
    public void test() {
        assertEquals("Hello World", new View().getText());
    }
}
