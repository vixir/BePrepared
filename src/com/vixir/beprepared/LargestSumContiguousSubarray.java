package com.vixir.beprepared;

public class LargestSumContiguousSubarray {

	public static int largestSumSubarray(int[] a) {
		if (a.length <= 0) {
			return 0;
		}
		int max_till_now = a[0];
		int max_ending_here = a[0];
		for (int i : a) {
			if ((i + max_ending_here) > i) {
				max_ending_here = i + max_ending_here;
			} else {
				max_ending_here = i;
			}
			if (max_ending_here > max_till_now) {
				max_till_now = max_ending_here;
			}
		}
		return max_till_now;
	}

	public static void main(String[] args) {
		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(largestSumSubarray(a));
	}

}
