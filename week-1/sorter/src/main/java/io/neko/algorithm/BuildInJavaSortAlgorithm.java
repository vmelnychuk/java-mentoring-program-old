package io.neko.algorithm;

import java.util.Arrays;

public class BuildInJavaSortAlgorithm implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        Arrays.sort(result);
        return result;
    }
}
