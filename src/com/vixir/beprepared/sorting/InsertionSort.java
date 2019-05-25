package com.vixir.beprepared.sorting;

/**
 * In insertion i, swap a[i] with each larger entry to it's left
 */
public class InsertionSort {

    public static void insertionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && isLess(a, j, j - 1); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void printArray(Comparable[] a) {
        StringBuilder builder = new StringBuilder();
        for (Object i : a) {
            builder.append(i.toString() + " ");
        }
        System.out.println(builder.toString());
    }

    private static boolean isLess(Comparable[] a, int i, int j) {
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
        Character[] charArray = {'I', 'N', 'S', 'E', 'R', 'S', 'T', 'I', 'O', 'N', 'S', 'O', 'R', 'T'};
        insertionSort(intArray);
        insertionSort(charArray);
        printArray(intArray);
        printArray(charArray);
    }
}
