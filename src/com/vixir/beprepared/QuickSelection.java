package com.vixir.beprepared;

public class QuickSelection {

	public static void main(String[] args) {
		Integer intArray[] = { 1, 2, 4, 5, 3, 6, 8, 7, 9 };
		System.out.println(quickSelect(intArray, 0));
		System.out.println(quickSelect(intArray, 1));
		System.out.println(quickSelect(intArray, 2));
		System.out.println(quickSelect(intArray, 3));
		System.out.println(quickSelect(intArray, 4));
		System.out.println(quickSelect(intArray, 5));
		System.out.println(quickSelect(intArray, 6));
		System.out.println(quickSelect(intArray, 7));
		System.out.println(quickSelect(intArray, 8));
	}

	// kth smallest item
	private static Comparable quickSelect(Comparable[] cArray, int k) {
		int lo = 0;
		int hi = cArray.length - 1;
		while (hi > lo) {
			int j = partition(cArray, lo, hi);
			if (j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			} else {
				return cArray[k];
			}
		}
		return cArray[k];
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (isLess(a, ++i, lo)) {
				if (i == hi) {
					break;
				}
			}
			while (isLess(a, lo, --j)) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	public static boolean isLess(Comparable[] a, int i, int j) {
		if (a[j].compareTo(a[i]) > 0) {
			return true;
		}
		return false;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
