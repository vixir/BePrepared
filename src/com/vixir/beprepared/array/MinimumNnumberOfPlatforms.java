package com.vixir.beprepared.array;

import java.util.*;

/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits.
 */
public class MinimumNnumberOfPlatforms {

    public static void main(String[] args) {
        int[] startTimes = new int[]{900, 900, 980, 920};
        int[] endTimes = new int[]{910, 910, 1010, 1010};
        System.out.println(minPlatform(startTimes, endTimes));
    }

    public static int minPlatform(int[] startTimes, int[] endTimes) {
        int startIndex = 0;
        int endIndex = 0;
        int nPlatforms = 0;
        int nMax = Integer.MIN_VALUE;
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        while (startIndex < startTimes.length && endIndex < endTimes.length) {
            if (startTimes[startIndex] < endTimes[endIndex]) {
                startIndex++;
                nPlatforms++;
                nMax = Math.max(nPlatforms, nMax);
            } else {
                endIndex++;
                nPlatforms--;
            }
        }
        return nMax;
    }
}