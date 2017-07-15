package com.vixir.beprepared.array;

public class MinimumElementRotatedArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 6, 1, 2, 3, 4 };
		int n1 = arr1.length;
		System.out.println("The minimum element is " + pivotArr(arr1, n1 - 1));

		int arr2[] = { 1, 2, 3, 4 };
		int n2 = arr2.length;
		System.out.println("The minimum element is " + pivotArr(arr2, n2 - 1));

		int arr3[] = { 1 };
		int n3 = arr3.length;
		System.out.println("The minimum element is " + pivotArr(arr3, n3 - 1));

		int arr4[] = { 1, 2 };
		int n4 = arr4.length;
		System.out.println("The minimum element is " + pivotArr(arr4, n4 - 1));

		int arr5[] = { 2, 1 };
		int n5 = arr5.length;
		System.out.println("The minimum element is " + pivotArr(arr5, n5 - 1));

		int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
		int n6 = arr6.length;
		System.out.println("The minimum element is " + pivotArr(arr6, n6 - 1));

		int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n7 = arr7.length;
		System.out.println("The minimum element is " + pivotArr(arr7, n7 - 1));

		int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
		int n8 = arr8.length;
		System.out.println("The minimum element is " + pivotArr(arr8, n8 - 1));

		int arr9[] = { 3, 4, 5, 1, 2 };
		int n9 = arr9.length;
		System.out.println("The minimum element is " + pivotArr(arr9, n9 - 1));

	}

	public static int pivotArr(int[] a, int n) {
		int start = 0;
		int end = n;
		while (start < end) {
			int mid = (start + end) / 2;
			if (a[start] <= a[end]) {
				return a[start];
			} else if (mid > start && a[mid] < a[mid - 1]) {
				return a[mid];
			} else if (a[start] > a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return a[start];
	}
}
