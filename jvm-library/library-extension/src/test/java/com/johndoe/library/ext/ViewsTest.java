package com.johndoe.library.ext;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ViewsTest {
    @Test
    public void test() {
        assertNotNull(Views.create());
    }
}
