package com.vixir.beprepared.dynamic;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int a[] = { 3, 4, -1, 0, 6, 2, 3 };
		int length = longestIncreasingSubsequence(a);
		System.out.println("\n longest increasing subsequence is " + length);
	}

	public static int longestIncreasingSubsequence(int[] a) {
		int j = 0;
		int i = 0;
		int length = 0;
		int ans[] = new int[a.length];

		for (i = 0; i < a.length; i++) {
			ans[i] = 1;
		}

		for (i = 1; i < a.length; i++) {
			while (j < i) {
				if (a[j] < a[i]) {
					ans[i] = Math.max(ans[i], ans[j] + 1);
					if (length < ans[i]) {
						length = ans[i];
					}
				}
				j++;
			}
			j = 0;
		}

		// printing the helper array
		/*
		 * for (int k : ans) { System.out.print(k + " "); }
		 */
		return length;
	}

}
