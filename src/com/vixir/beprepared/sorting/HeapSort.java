package com.vixir.beprepared.sorting;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] a = {4, 5, 2, 9, 8, 1, 7};
        HeapSort heap = new HeapSort();
        heap.heapSort(a);
    }

    public void heapSort(Comparable[] a) {
        int N = a.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            sink(a, i, N);
        }
        while (N > 1) {
            swap(a, 0, N);
            sink(a, 0, --N);
        }
        printArray(a);
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

    private boolean less(Comparable[] a, int j, int k) {
        int x = a[j].compareTo(a[k]);
        if (x < 0) {
            return true;
        }
        return false;
    }

    private static void printArray(Comparable[] a) {
        StringBuilder builder = new StringBuilder();
        for (Object i : a) {
            builder.append(String.valueOf(i) + " ");
        }
        System.out.println(builder.toString());
    }
}
