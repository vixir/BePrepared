package com.vixir.beprepared.stack;

public class WaterArea {

    public static void main(String[] args) {
        System.out.println(waterArea(new int[]{4, 2, 4}));
        System.out.println(waterAreaOptimized(new int[]{4, 2, 4}));
    }


    //Optimized Solution
    public static int waterAreaOptimized(int[] heights) {
        int n = heights.length;
        int[] maxContent = new int[n];
        int maxTillNowFromLeft = 0;
        int maxTillNowFromRight = 0;

        for (int i = 0; i < n; i++) {
            maxContent[i] = maxTillNowFromLeft;
            maxTillNowFromLeft = Math.max(heights[i], maxTillNowFromLeft);
        }

        int sol = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minHeight = Math.min(maxContent[i], maxTillNowFromRight);
            if (heights[i] < minHeight) {
                sol += minHeight - heights[i];
            } else {
                maxContent[i] = 0;
            }
            maxTillNowFromRight = Math.max(maxTillNowFromRight, heights[i]);
        }

        return sol;
    }

    //Initial Solution
    public static int waterArea(int[] heights) {
        int n = heights.length;
        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];
        int maxTillNowFromLeft = 0;
        int maxTillNowFromRight = 0;

        for (int i = 0; i < n; i++) {
            maxFromLeft[i] = maxTillNowFromLeft;
            maxTillNowFromLeft = Math.max(heights[i], maxTillNowFromLeft);
        }

        for (int i = n - 1; i >= 0; i--) {
            maxFromRight[i] = maxTillNowFromRight;
            maxTillNowFromRight = Math.max(heights[i], maxTillNowFromRight);
        }

        int sol = 0;

        for (int i = 1; i < n - 1; i++) {
            int smaller = Math.min(maxFromRight[i], maxFromLeft[i]);
            if (heights[i] < smaller) {
                int diff = smaller - heights[i];
                sol += diff;
            }
        }

        return sol;
    }


}
