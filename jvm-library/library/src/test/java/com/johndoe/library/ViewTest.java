package com.johndoe.library;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class ViewTest {
    @Test
    public void test() {
        assertThat(new View().getText()).isEqualTo("Hello World");
    }
}
