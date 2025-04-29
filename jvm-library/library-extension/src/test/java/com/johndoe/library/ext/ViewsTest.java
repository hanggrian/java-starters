package com.johndoe.library.ext;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class ViewsTest {
    @Test
    public void test() {
        assertThat(Views.create()).isNotNull();
    }
}
