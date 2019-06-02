package com.vixir.beprepared.sliding_windows;

// Given an array of integers of size n
// Our aim is to calculate the maximum sum possible for ‘k’ consecutive elements in the array. k<=n

public class MaxSumOfSubArraysOfSizeK {

    public static void main(String[] args) {
        int[] a = {100, 200, 300, 500, 2, 400, 700, 250};
        System.out.println(kWindowMaxSum(a, 5));
    }

    private static int kWindowMaxSum(int[] a, int k) {
        int maxSum = 0, windowSum = 0;
        //calculate sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += a[i];
        }
        maxSum = windowSum;
        /* slide window from start to end in array. */

        for (int i = k; i < a.length; i++) {
            windowSum += a[i] - a[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
