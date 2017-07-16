package com.vixir.beprepared.array;

import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int array[] = { 12, 3, 2, 5, 6, 8, 19 };
		twoSum.printTwoSum(array, 11);
	}

	public void printTwoSum(int[] array, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			if (set.contains(sum - i)) {
				System.out.println(i + " " + (sum - i));
				return;
			} else {
				set.add(i);
			}
		}
	}
}
