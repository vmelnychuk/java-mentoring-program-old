package io.neko.algorithm;

import java.util.Arrays;

public class BubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);

        for (int i = result.length - 1; i > 1; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (result[j] > result[j + 1]) {
                    swapped = true;
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }

            if (!swapped) {
                break;
            }
        }
        return result;
    }
}
