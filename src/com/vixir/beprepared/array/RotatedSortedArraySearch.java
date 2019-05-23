package com.vixir.beprepared.array;


/**
 * Given a rotated sorted array at some unknown pivot.
 * Find index of target element to search. If element is not found return -1
 */
public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        int a[] = {40, 45, 20, 25, 30, 35};
        System.out.println(searchIndex(a, 40));
        System.out.println(searchIndex(a, 45));
        System.out.println(searchIndex(a, 20));
        System.out.println(searchIndex(a, 25));
        System.out.println(searchIndex(a, 30));
        System.out.println(searchIndex(a, 35));
    }

    private static int searchIndex(int[] a, int b) {
        int pivot = MinimumElementRotatedArray.pivotArr(a, a.length - 1);
        if (a[pivot] == b) {
            return pivot;
        } else if (b <= a[a.length - 1]) {
            return binarySearch(a, pivot + 1, a.length - 1, b);
        } else {
            return binarySearch(a, 0, pivot - 1, b);
        }
    }

    private static int binarySearch(int[] a, int lo, int hi, int b) {
        if (lo < 0 || hi >= a.length) {
            return -1;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int temp = a[mid];
            if (temp == b) {
                return mid;
            } else if (temp < b) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
