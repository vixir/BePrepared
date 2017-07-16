package com.vixir.beprepared.array;

public class TwoSumWithSortedArray {

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		printTwoSum(array, 12);
		printTwoSumUsingBinarySearch(array, 12);
	}

	private static void printTwoSum(Integer[] array, int sum) {
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			int tempSum = array[i] + array[j];
			if (tempSum < sum) {
				i++;
			} else if (tempSum > sum) {
				j--;
			} else {
				System.out.println(array[i] + " " + array[j]);
				return;
			}
		}
		System.out.println("Not Found");
	}

	private static void printTwoSumUsingBinarySearch(Integer[] array, Integer sum) {
		for (Integer i : array) {
			if (binarySearch(array, sum - i)) {
				System.out.println(i + " " + (sum - i));
				return;
			}
		}
		System.out.println("Not Found");
	}

	private static boolean binarySearch(Integer[] array, Integer i) {
		int lo = 0;
		int hi = array.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int comp = i.compareTo(mid);
			if (comp < 0) {
				hi = mid - 1;
			} else if (comp > 0) {
				lo = mid + 1;
			} else if (comp == 0) {
				return true;
			}
		}
		return false;
	}

}
