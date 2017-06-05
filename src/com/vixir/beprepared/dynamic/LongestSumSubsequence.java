package com.vixir.beprepared.dynamic;

public class LongestSumSubsequence {

	public static void main(String[] args) {
		int a[] = { 4, 6, 1, 3, 8, 4, 6 };
		int sol = longestSumSubseq(a);
		System.out.println("max increasing sum subsequence is = " + sol);
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println("max increasing sum subsequence is = " + longestSumSubseq(arr));
	}

	public static int longestSumSubseq(int[] a) {
		int n = a.length, maxSum = Integer.MIN_VALUE;
		int[] sumArr = new int[n];
		int[] sequenceArr = new int[n];

		for (int i = 0; i < a.length; i++) {
			sumArr[i] = a[i];
			sequenceArr[i] = i;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				int currSum = sumArr[i] + a[j];
				if (a[i] > a[j] && sumArr[i] < currSum) {
					sumArr[i] = currSum;
				}
			}
			if (maxSum < sumArr[i]) {
				maxSum = sumArr[i];
			}
		}
		return maxSum;
	}

}
