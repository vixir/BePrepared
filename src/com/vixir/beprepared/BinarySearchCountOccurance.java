package com.vixir.beprepared;

import java.util.Arrays;
import java.util.List;

public class BinarySearchCountOccurance {

	// Count occurrence of a given number in sorted array
	
	public static void main(String[] args) {
		Integer[] a = { 2, 2, 2, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 22, 22, 22, 22, 22, 42, 42, 42, 42, 42,
				42, 42, 55, 55, 55, 55, 55 };
		List<Integer> list = Arrays.asList(a);
		String format = "%d occurs %d times";
		System.out.println(String.format(format, 42, findCount(list, 42)));
		System.out.println(String.format(format, 2, findCount(list, 2)));
		System.out.println(String.format(format, 6, findCount(list, 6)));
		System.out.println(String.format(format, 7, findCount(list, 9)));
		System.out.println(String.format(format, 43, findCount(list, 43)));
	}

	public static int findCount(final List<Integer> a, int b) {
		int first = getFirstOccurance(a, b);

		if (first == -1) {
			return 0;
		}

		int last = getLastOccurance(a, b);
		return last - first + 1;
	}

	private static int getLastOccurance(List<Integer> a, int b) {
		int n = a.size() - 1;
		int i = 0;
		int result = -1;
		while (i <= n) {
			int m = (i + n) / 2;
			int v = a.get(m);
			if (v == b) {
				result = m;
				i = m + 1;
			} else if (v < b) {
				i = m + 1;
			} else {
				n = m - 1;
			}
		}
		return result;
	}

	private static int getFirstOccurance(List<Integer> a, int b) {
		int n = a.size();
		int i = 0;
		int result = -1;
		while (i <= n) {
			int m = (i + n) / 2;
			int v = a.get(m);
			if (v == b) {
				result = m;
				n = m - 1;
			} else if (v < b) {
				i = m + 1;
			} else {
				n = m - 1;
			}
		}
		return result;
	}
}
