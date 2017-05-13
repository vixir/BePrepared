package com.vixir.beprepared.sorting;

public class MergeSort {

	public static void mergeSort(Comparable[] a) {
		int n = a.length;
		Comparable aux[] = new Comparable[n];
		mergeSort(a, aux, 0, n - 1);
	}

	private static void mergeSort(Comparable[] a, Comparable[] aux, int j, int k) {
		if (k <= j) {
			return;
		}
		int mid = (j + k) / 2;
		mergeSort(a, aux, j, mid);
		mergeSort(a, aux, mid + 1, k);
		merge(a, aux, j, mid, k);
	}

	private static void merge(Comparable[] a, Comparable aux[], int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (isLess(aux, j, i)) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	public static boolean isLess(Comparable[] a, int i, int j) {
		if (a[j].compareTo(a[i]) > 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Integer intArray[] = { 4, -3, 5, 6, 8, -9, 4, 1 };
		Character[] charArray = { 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T' };
		mergeSort(intArray);
		mergeSort(charArray);
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
