package com.vixir.beprepared.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        for (int lastIndex = array.length - 1; lastIndex >= 1; lastIndex--) {
            for (int startIndex = 0; startIndex < lastIndex; startIndex++) {
                if (isLess(array, startIndex + 1, startIndex)) {
                    exch(array, startIndex, startIndex + 1);
                }
            }
        }
        return array;
    }

    private static boolean isLess(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{-5, -2, 2, -8, 3, -10, -6, -1, 2, -2, 9, 1, 1})));
    }
}
