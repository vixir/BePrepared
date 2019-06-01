package com.vixir.beprepared.array;

import java.util.*;

//Given a collection of intervals, merge all overlapping intervals
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

//Solution Approach :
// Scenario 1 : [1,3] [2,6]
// Merge : [1,6]
// Scenario 2 : [1,5] [2,3]
// Merge : [1,5]
// Scenario 3 : [1,3] [3,6]
// Merge : [1,6]
// Scenario 4 : [4,7] [1,5]
// Merge : [1,7]
// 1) For scenario 1 and 3 we will compare end of the first array and start of the second array and merge them
// 2) For scenario 2, we need to take largest of the end of both the arrays after applying scenario 1.
// 3) For scenario 3, we need to sort both the arrays and apply scenario 1 or scenario 2.
public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {

        List<int[]> solution = new ArrayList<>();
        if (intervals.length == 0) {
            return null;
        }

//      Sort by first element
        Arrays.sort(intervals, Comparator.comparingInt(first -> first[0]));

        int[] lastMergedInterval = intervals[0];
        solution.add(lastMergedInterval);

        for (int[] interval : intervals) {
            lastMergedInterval = solution.get(solution.size() - 1);
            if (interval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[0], interval[1]);
            } else {
                solution.add(interval);
            }
        }
        return solution.toArray(new int[solution.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Given Array :");
        Arrays.stream(intervals).forEach(interval -> System.out.print(Arrays.toString(interval) + " "));
        System.out.println("\nSolution :");
        Arrays.stream(mergeIntervals.mergeIntervals(intervals)).forEach(interval -> System.out.print(Arrays.toString(interval) + " "));
    }
}
