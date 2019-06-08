package com.vixir.beprepared.array;

import java.util.*;

/**
 * Given a target sum and an array, print a pair of numbers summing up to target sum.
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int array[] = {12, 3, 2, 5, 2, 8, 19};
        twoSum.printTwoSum(array, 11);
        twoSum.printTwoSumSortSolution(array, 11);
    }

    /**
     * @param array
     * @param targetSum
     * Iterate over array and search for (targetSum-current),
     * if not found then add current element to the set.
     * If found then we have our two sum pair.
     */
    public void printTwoSum(int[] array, int targetSum) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int current : array) {
            if (set.contains(targetSum - current)) {
                System.out.println(current + " " + (targetSum - current));
                return;
            } else {
                set.add(current);
            }
        }
        System.out.println("Two sum pair not found");
    }

    /**
     * @param array
     * @param targetSum
     *
     * Array sort solution for two sum
     */
    public void printTwoSumSortSolution(int[] array, int targetSum) {
        // Sort the given array (nlog(n))
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            //if targetSum is less than the sum of left and right index elements, then decrease the right index,
            // so that the sum of left index element and right index element becomes more.
            //if targetSum is more than the sum of left and right index elements, then increase the left index,
            // so that the sum of left index and right index elements becomes less.
            if (targetSum < (array[left] + array[right])) {
                right--;
            } else if (targetSum > (array[left] + array[right])) {
                left++;
            } else {
                System.out.println(array[left] + " " + array[right]);
                return;
            }
        }
        System.out.println("Two sum pair not found");
    }
}
