package io.neko.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildInJavaSortAlgorithmTest {
    private SortAlgorithm sortAlgorithm;

    @Before
    public void setUp() {
        sortAlgorithm = new BuildInJavaSortAlgorithm();
    }

    @Test
    public void givenSortedArrayWhenSortThenReturnSortedArray() {
        int[] input = {1, 2, 3, 4};
        int[] sortedInput = {1, 2, 3, 4};

        int[] result = sortAlgorithm.sort(input);

        assertArrayEquals(sortedInput, result);
    }

    @Test
    public void givenUnsortedArrayWhenSortThenReturnSortedArray() {
        int[] input = {-10, 3, -900, -444, 4};
        int[] sortedInput = {-900, -444, -10, 3, 4};

        int[] result = sortAlgorithm.sort(input);

        assertArrayEquals(sortedInput, result);
    }
}
