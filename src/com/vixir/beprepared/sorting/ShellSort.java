package com.vixir.beprepared.sorting;

public class ShellSort {

    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && isLess(a, j, j - h); j = j - h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
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
        Integer intArray[] = {4, -3, 5, 6, 8, -9, 4, 1};
        Character[] charArray = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T'};
        shellSort(intArray);
        shellSort(charArray);
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
