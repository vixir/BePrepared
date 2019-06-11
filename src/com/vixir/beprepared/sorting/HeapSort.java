package com.vixir.beprepared.sorting;

import java.util.*;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] a = {4, 5, 2, 9, 8, 1, 7};
        HeapSort heap = new HeapSort();
        heap.heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void heapSort(Comparable[] a) {
        int N = a.length - 1;
        // create a maxHeap
        for (int i = N / 2 - 1; i >= 0; i--) {
            sink(a, i, N);
        }
        // swap top element with current index
        while (N > 1) {
            swap(a, 0, N);
            sink(a, 0, --N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (2 * k + 2 <= N) {
            int j = 2 * k + 1;
            j = less(a, j, j + 1) ? j + 1 : j; // bigger one to j
            if (less(a, k, j)) {
                swap(a, k, j);
            }
            k = j;
        }
    }

    private void swap(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * @param a comparable array
     * @param j
     * @param k
     * @return is a[j] less than a[k]
     */
    private boolean less(Comparable[] a, int j, int k) {
        int x = a[j].compareTo(a[k]);
        return (x < 0) ? true : false;
    }

}
