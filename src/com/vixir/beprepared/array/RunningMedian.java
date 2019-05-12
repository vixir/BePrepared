package com.vixir.beprepared.array;

import java.util.*;
import java.util.stream.*;

public class RunningMedian {

    public static double[] getMedians(int[] arr) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder()); // min heap
        PriorityQueue<Integer> right = new PriorityQueue<>(); // max heap
        double medians[] = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            addNumber(left, right, number);
            reBalance(left, right);
            medians[i] = getMedian(left, right);
        }
        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        } else {
            return (Math.max(left.size(), right.size()) == left.size()) ? left.peek() : right.peek();
        }
    }

    private static void reBalance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        PriorityQueue<Integer> biggerHeap = left.size() > right.size() ? left : right;
        PriorityQueue<Integer> smallerHeap = left.size() > right.size() ? right : left;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static void addNumber(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int number) {
        if (left.size() > right.size()) {
            right.add(number);
        } else {
            left.add(number);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 9};
        double[] medians = getMedians(arr);
        DoubleStream.of(medians).forEach(System.out::println);
    }

}
