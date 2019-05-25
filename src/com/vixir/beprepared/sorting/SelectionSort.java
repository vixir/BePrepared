package com.vixir.beprepared.sorting;

/**
 * In iteration i find the smallest remaining entry in array a[]. smallest entry index -> min
 * Swap a[i] and a[min]
 */
public class SelectionSort {

    public static void selectionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (isLess(a, j, min)) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
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

    private static void printArray(Comparable[] a) {
        StringBuilder builder = new StringBuilder();
        for (Object i : a) {
            builder.append(i.toString() + " ");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Integer intArray[] = {4, -3, 5, 6, 8, -9, 4, 1};
        Character[] charArray = {'S', 'E', 'L', 'E', 'C', 'T', 'I', 'O', 'N'};
        selectionSort(intArray);
        selectionSort(charArray);
        printArray(intArray);
        printArray(charArray);
    }


}
