package com.vixir.beprepared.array;

/**
 * Subarray Sort
 * Return start and end indices of the smalled subarray in the input array that needs to be sorted in place in order
 * for entire array to be sorted
 */
public class SmallestUnSortedArray {
    public static int[] subarraySort(int[] array) {
        int n = array.length;
        int minUnSort = Integer.MAX_VALUE;
        int maxUnSort = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (isOutOfOrder(i, array)) {
                minUnSort = Math.min(array[i], minUnSort);
                maxUnSort = Math.max(array[i], maxUnSort);
            }
        }

        if (minUnSort == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = array.length - 1;

        while (minUnSort >= array[left]) {
            left++;
        }

        while (maxUnSort <= array[right]) {
            right--;
        }

        return new int[]{left, right};
    }

    private static boolean isOutOfOrder(int i, int[] array) {
        if (i == 0) {
            return array[i] > array[i + 1];
        } else if (i == array.length - 1) {
            return array[i] < array[i - 1];
        } else {
            return (array[i] > array[i + 1]) || (array[i] < array[i - 1]);
        }
    }

}
