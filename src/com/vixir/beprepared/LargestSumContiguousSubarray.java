package com.vixir.beprepared;

public class LargestSumContiguousSubarray {

	// Kadane's Algorithm

	public static int largestSumSubarray(int[] a) {
		int max_till_now = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for (int i : a) {
			max_ending_here = i + max_ending_here;
			if (max_ending_here > max_till_now) {
				max_till_now = max_ending_here;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
		}
		return max_till_now;
	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// maxSumSubarray = 4-1-2+1+5 = 7
		System.out.println(largestSumSubarray(a));
	}

}
