package com.vixir.beprepared.sorting;

public class QuickSort {

	// good algorithms are better than supercomputers
	// great algorithms are better than good ones. :)
	//compares is 1.39 lg N
	//worst case quadratic
	public static void quickSort(Comparable[] a) {
		int n = a.length;
		// UniformShuffle.shuffle(a); //for shuffling.
		quickSort(a, 0, n - 1);
	}

	private static void quickSort(Comparable[] a, int i, int j) {

		if (j <= i) {
			return;
		}

		int partition = partition(a, i, j);
		quickSort(a, i, partition - 1);
		quickSort(a, partition + 1, j);
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

	public static void main(String[] args) {
		Integer intArray[] = { 4, -3, 5, 6, 8, -9, 4, 1 };
		Character[] charArray = { 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T' };
		quickSort(intArray);
		quickSort(charArray);
		printArray(intArray);
		printArray(charArray);
	}

	private static void printArray(Comparable[] a) {
		StringBuilder builder = new StringBuilder();
		for (Object i : a) {
			builder.append(String.valueOf(i) + " ");
		}
		System.out.println(builder.toString());
	}
}
