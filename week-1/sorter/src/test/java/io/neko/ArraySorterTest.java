package io.neko;

import io.neko.algorithm.SortAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArraySorterTest {
    @Mock
    private SortAlgorithm algorithm = mock(SortAlgorithm.class);

    @InjectMocks
    private ArraySorter arraySorter;

    @Before
    public void setUp() {
        when(algorithm.sort(any(int[].class))).thenReturn(new int[]{});
    }

    @Test
    public void givenArrayWhenSortThenReturnSortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expectedArray = new int[] {};

        int[] sortedArray = arraySorter.doSort(array);

        assertArrayEquals(expectedArray, sortedArray);
        verify(algorithm).sort(array);
    }
}
