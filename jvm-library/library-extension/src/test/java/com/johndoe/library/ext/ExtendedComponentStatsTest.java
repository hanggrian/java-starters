package com.johndoe.library.ext;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExtendedComponentStatsTest {
    @Mock
    private Component component;

    @Test
    public void test() {
        when(component.getX()).thenReturn(0);
        when(component.getY()).thenReturn(1);
        assertThat(new ExtendedComponentStats(component).getPosition()).isEqualTo("(0,1)");
        verify(component).getX();
        verify(component).getY();
    }
}
