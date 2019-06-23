package com.vixir.beprepared.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * I read the solution for this problem a month ago, but didn't find the code that I was looking for.
 * Whatever solution I saw online didn't resonate with me.
 * Coming to the problem the O(N^2) solution.
 * For O(n^2), we maintain 2 arrays, one for keeping the sequence and other for keeping the value of
 * longest increasing subsequence till the index that we are processing .
 * <p>
 * For O(NlogN) solution, we need to maintain a sequence array in the same way we did it for the previous approach.
 * The other array will store indexes in such a way that values for the indexes are sorted.
 */
public class LongestIncreasingSubsequenceNLogN {

    private static List<Integer> longestIncreasingSubsequence(int[] input) {
        List<Integer> sol = new ArrayList<>();

        int[] sequences = new int[input.length];

        List<Integer> lengthList = new ArrayList<>();

        int maxLength = 0;

        for (int i = 0; i < input.length; i++) {
            int index = findCeilIndexPosition(lengthList, input, 0, lengthList.size() - 1, input[i]);
            if (index != 0) {
                sequences[i] = lengthList.get(index - 1);
            } else {
                sequences[i] = -1;
            }

            if (index <= lengthList.size() - 1) {
                lengthList.set(index, i);
            } else {
                lengthList.add(index, i);
            }

            maxLength = Math.max(maxLength, index);
        }

        buildSolution(sol, input, sequences, lengthList.get(maxLength));

        return sol;
    }

    private static void buildSolution(List<Integer> sol, int[] input, int[] sequences, Integer currentIndex) {
        while (currentIndex != -1) {
            sol.add(0, input[currentIndex]);
            currentIndex = sequences[currentIndex];
        }
    }

    private static int findCeilIndexPosition(List<Integer> lengthList, int[] input, int lo, int hi, int value) {
        while (lo <= hi) {
            int mid = (lo + hi + 1) / 2;
            if (input[lengthList.get(mid)] < value) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestIncreasingSubsequence(new int[]{4, 12, 5, 6, 2, 3, 9, 14}).toArray()));
    }

}
