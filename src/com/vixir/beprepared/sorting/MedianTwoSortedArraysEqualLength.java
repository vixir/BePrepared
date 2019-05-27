package com.vixir.beprepared.sorting;

import java.util.Arrays;

/**
 * Find median of two sorted arrays of unequal length
 */
public class MedianTwoSortedArraysEqualLength {

    private static final String LOG_FORMAT = "Median of \n %s \n %s \n Answer : %s";

    public static void main(String[] args) {
        int[] a = {4, 7, 10, 13, 19, 24};
        int[] b = {3, 6, 9, 15, 18, 23};

        System.out.println(String.format(LOG_FORMAT, Arrays.toString(a), Arrays.toString(b), median(a, b)));
        int[] c = {4, 7, 10, 13, 19};
        int[] d = {3, 6, 9, 15, 18};

        System.out.println(String.format(LOG_FORMAT, Arrays.toString(c), Arrays.toString(d), median(c, d)));

    }

    private static double median(int[] a, int[] b) {
        ModifiedArray A = new ModifiedArray(a);
        ModifiedArray B = new ModifiedArray(b);
        return median(A, B);
    }

    private static double median(ModifiedArray a, ModifiedArray b) {
        if (a.getSize() == 1) {
            return ((a.getFirst() + b.getFirst())) / 2.0;
        }
        if (a.getSize() == 2) {
            return (Math.max(a.getFirst(), b.getFirst()) + Math.min(a.getLast(), b.getLast())) / 2.0;
        }
        return a.getMedian() > b.getMedian() ?
                median(a.fromArray(a.start, a.getSize() / 2), b.fromArray(b.getSize() / 2, b.getSize()))
                : median(a.fromArray((a.getSize() - 1) / 2, (a.end - a.start) / 2), b.fromArray((b.end - b.start) / 2, b.end));
    }

}

class ModifiedArray {
    /**
     * start of the parent array (inclusive)
     */
    int start;
    /**
     * end of the parent array (exclusive)
     */
    int end;

    /**
     * Array input for ModifiedArray
     */
    int[] parentArray;

    int size;

    public ModifiedArray(int[] a) {
        this.start = 0;
        this.parentArray = a;
        this.end = a.length;
        size = a.length;
    }

    public ModifiedArray fromArray(int start, int end) {
        ModifiedArray modifiedArray = new ModifiedArray(this.parentArray);
        modifiedArray.start = start;
        modifiedArray.end = end;
        size = modifiedArray.end - modifiedArray.start;
        return modifiedArray;
    }

    public double getMedian() {
        if ((end - start) % 2 == 0) {
            return (parentArray[start + size / 2 - 1] + parentArray[size / 2 + start]) / 2.0;
        } else {
            return parentArray[start + size / 2];
        }
    }

    public int getFirst() {
        return parentArray[start];
    }

    public int getLast() {
        return parentArray[end - 1];
    }

    public int getSize() {
        return size;
    }

}

