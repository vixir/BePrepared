package com.vixir.beprepared.sorting;

public class ThreeWaySort {

    //Dijkstra 3 Way Partition sort

    public static void main(String[] args) {
        int[] a = {4, 5, 4, 4, 4, 6, 6, 6, 7, 7, 7, 3, 3, 3, 7, 5, 5, 5, 3};
        threeWaySort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void threeWaySort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int ht = hi;
        int v = a[lo];
        int i = lo;
        while (i <= ht) {
            if (a[i] < v) {
                exch(a, lt++, i++);
            } else if (a[i] > v) {
                exch(a, i, ht--);
            } else
                i++;
        }
        threeWaySort(a, lo, lt - 1);
        threeWaySort(a, ht + 1, hi);

    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
