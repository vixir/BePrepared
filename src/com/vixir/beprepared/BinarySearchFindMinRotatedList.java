package com.vixir.beprepared;

import java.util.Arrays;
import java.util.List;

public class BinarySearchFindMinRotatedList {

	public static void main(String[] args) {
		Integer[] a = { 5, 6, 7, 8, 2, 3, 4 };
		List<Integer> list = Arrays.asList(a);
		String format = "Min element is %d and the list is rotated at position %d starting from 0.";
		int pivot = getPivot(list);
		if (pivot == -1) {
			return;
		}
		System.out.println(String.format(format, list.get(pivot), pivot));
	}

	private static int getPivot(List<Integer> list) {
		int ht = list.size();
		if (ht < 1) {
			return 0;
		}
		int lt = 0;
		ht = ht - 1;
		while (lt <= ht) {
			if (list.get(lt) <= list.get(ht)) {
				return lt;
			}
			int mid = (lt + ht) / 2;
			if (list.get(mid) <= list.get(ht) && list.get(mid) <= list.get(lt)) {
				return mid;
			} else if (list.get(mid) > list.get(ht)) {
				lt = mid + 1;
			} else if (list.get(mid) < list.get(lt)) {
				ht = mid - 1;
			}
		}
		return -1;
	}

}
