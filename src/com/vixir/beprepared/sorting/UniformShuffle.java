package com.vixir.beprepared.sorting;

import java.util.Random;

public class UniformShuffle {

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		shuffle(a);
		printArray(a);
	}

	public static void shuffle(Comparable[] a) {
		int n = a.length;
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int r = random.nextInt(i+1); // correct method is picking a number between 0 and i or i and n-1
			exch(a, i, r);
		}
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
}
