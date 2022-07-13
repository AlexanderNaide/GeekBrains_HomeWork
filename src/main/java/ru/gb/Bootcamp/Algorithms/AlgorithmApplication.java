package ru.gb.Bootcamp.Algorithms;

import java.util.Arrays;

public class AlgorithmApplication {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 1, 2, 7, 8, 4, 6, 9};
        DirectSort.sort(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = new int[]{5, 3, 9, 2, 7, 8, 4, 6, 1};
        BubbleSort.sort(array2);
        System.out.println(Arrays.toString(array2));


        //----------------35:00-------------------
    }
}
