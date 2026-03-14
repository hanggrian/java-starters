package com.johndoe.application;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComponentStatsTest {
    @Mock private Component component;

    @Test
    public void test() {
        when(component.getWidth()).thenReturn(2);
        when(component.getHeight()).thenReturn(4);
        assertThat(new ComponentStats(component).getSize()).isEqualTo(8);
        verify(component).getWidth();
        verify(component).getHeight();
    }
}
