package com.vixir.beprepared.dynamic;

import java.util.*;
import java.util.stream.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int a[] = {3, 4, -1, 0, 6, 2, 3};
        System.out.println("\n longest increasing subsequence is " + longestIncreasingSubsequence(a));
    }

    public static ArrayList<Integer> longestIncreasingSubsequence(int[] a) {
        int[] lenStore = new int[a.length];
        // will store the indices of the array which will help to create LongestIncreasingSubsequence
        int[] indices = new int[a.length + 1];
        //this will store the maximum subsequence length
        int length = 0;

        IntStream.range(0, a.length + 1).forEach(i -> indices[i] = Integer.MIN_VALUE);

        for (int i = 0; i < a.length; i++) {
            //starting from index 1, for recursive binarySearch
            int updatedLength = binarySearch(1, length, indices, a, a[i]);
            lenStore[i] = indices[updatedLength - 1];
            indices[updatedLength] = i;
            length = Math.max(length, updatedLength);
        }
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = indices[length]; indices[i] != Integer.MIN_VALUE; ) {
            sol.add(0, a[i]);
            i = indices[i];
        }
        return sol;
    }

    private static int binarySearch(int left, int right, int[] indices, int[] a, int x) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (a[indices[mid]] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return binarySearch(left, right, indices, a, x);
    }

}
