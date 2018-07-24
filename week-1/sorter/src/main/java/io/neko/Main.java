package io.neko;

import io.neko.algorithm.BubbleSortAlgorithm;
import io.neko.algorithm.BuildInJavaSortAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrayToSort = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            int element = Integer.valueOf(args[i]);
            arrayToSort[i] = element;
        }
        ArraySorter arraySorter = new ArraySorter();

        System.out.println("Select algorithm of sorting:");
        System.out.println(
            "1) Bubble sort\n" +
            "2) Java Arrays.sort()");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String algorithmNumber = scanner.nextLine();

        switch (algorithmNumber) {
            case "1":
                arraySorter.setSortAlgorithm(new BubbleSortAlgorithm());
                break;
            case "2":
                arraySorter.setSortAlgorithm(new BuildInJavaSortAlgorithm());
                break;
            default:
                arraySorter.setSortAlgorithm(new BubbleSortAlgorithm());
                break;
        }

        long start = System.currentTimeMillis();
        int[] sortedArray = arraySorter.doSort(arrayToSort);
        long end = System.currentTimeMillis();
        String arrayString = Arrays.toString(sortedArray);
        String formatterArrayString = arrayString.replaceAll("[,\\[\\]]", "");
        System.out.println(formatterArrayString);
        double elapsed = (end - start) / 1000.0;
        System.out.format("time elapsed: %.2fs\n", elapsed);
    }
}
