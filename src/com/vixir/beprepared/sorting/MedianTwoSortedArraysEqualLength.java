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
        double medianA = a.getMedian();
        double medianB = b.getMedian();
        if (medianB == medianA) {
            return medianB;
        }
        return medianA > medianB ?
                median(a.fromArray(0, a.getSize() / 2 + 1), b.fromArray((b.getSize() - 1) / 2, b.getSize()))
                : median(a.fromArray((a.getSize() - 1) / 2, a.getSize()), b.fromArray(0, b.getSize() / 2 + 1));
    }

}

class ModifiedArray {
    /**
     * start of the parent array (inclusive)
     */
    private int start;

    /**
     * Array input for ModifiedArray
     */
    private int[] parentArray;

    private int size;

    public ModifiedArray(int[] a) {
        this.start = 0;
        this.parentArray = a;
        size = a.length;
    }

    public ModifiedArray() {
    }

    public ModifiedArray fromArray(int startIndex, int endIndex) {
        ModifiedArray modifiedArray = new ModifiedArray();
        modifiedArray.parentArray = this.parentArray;
        modifiedArray.start = this.start + startIndex;
        modifiedArray.size = endIndex - startIndex;
        return modifiedArray;
    }

    public double getMedian() {
        if (size % 2 == 0) {
            return (parentArray[start + size / 2 - 1] + parentArray[size / 2 + start]) / 2.0;
        } else {
            return parentArray[start + size / 2];
        }
    }

    public int getFirst() {
        return parentArray[start];
    }

    public int getLast() {
        return parentArray[start + size - 1];
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }
}

