package io.neko;

import io.neko.algorithm.BubbleSortAlgorithm;
import io.neko.algorithm.SortAlgorithm;

public class ArraySorter {
    private SortAlgorithm sortAlgorithm;

    public ArraySorter() {
        this.sortAlgorithm = new BubbleSortAlgorithm();
    }

    public void setSortAlgorithm(SortAlgorithm algorithm) {
        this.sortAlgorithm = algorithm;
    }

    public int[] doSort(int[] array) {
        return sortAlgorithm.sort(array);
    }
}
