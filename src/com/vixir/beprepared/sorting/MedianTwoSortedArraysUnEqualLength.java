package com.vixir.beprepared.sorting;

import java.util.Arrays;

/**
 * Find median of two sorted arrays of unequal length
 */
public class MedianTwoSortedArraysUnEqualLength {

    private static final String LOG_FORMAT = "Median of \n %s \n %s \n Answer : %s";

    public static void main(String[] args) {
        int[] a = {4, 7, 10, 13, 19, 24};
        int[] b = {3, 6, 9, 15, 18, 23};

        System.out.println(String.format(LOG_FORMAT, Arrays.toString(a), Arrays.toString(b), median(a, b)));
        int[] c = {4, 7, 10, 13, 19};
        int[] d = {3, 6, 9, 15, 18, 23};

        System.out.println(String.format(LOG_FORMAT, Arrays.toString(a), Arrays.toString(b), median(c, d)));

    }

    private static double median(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            //calculate partitions
            int partitionA = (hi + lo) / 2;

            // +1 is to make the calculation easier : median will always be on left partition of A or B
            int partitionB = (lenA + lenB + 1) / 2 - partitionA;

            // fetch values from array based on partitions
            int leftA = partitionA > 0 ? a[partitionA - 1] : Integer.MIN_VALUE;
            int rightA = partitionA < a.length - 1 ? a[partitionA] : Integer.MAX_VALUE;
            int leftB = partitionB > 0 ? b[partitionB - 1] : Integer.MIN_VALUE;
            int rightB = partitionB < b.length - 1 ? b[partitionB] : Integer.MAX_VALUE;

            if (leftA < rightB && leftB < rightA) {
                if ((lenA + lenB) % 2 == 0) {
                    return ((double) Math.max(leftA, leftB) + (double) Math.min(rightA, rightB)) / 2;
                } else {
                    return (double) Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                lo--;
            } else {
                hi++;
            }
        }
        return -1;
    }

}
