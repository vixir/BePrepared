package com.vixir.beprepared.recursion;

public class AllPossiblePermutations {

	public static void main(String[] args) {
		char[] cArray = { 'A', 'B', 'C'};
		printString(cArray, 0);
	}

	private static void printString(char[] cArray, int k) {
		if (cArray.length == k) {
			printCharArray(cArray);
		} else {
			for (int j = k; j < cArray.length; j++) {
				swap(cArray, j, k);
				printString(cArray, k + 1);
				swap(cArray, j, k);
			}
		}
	}

	private static void swap(char[] cArray, int j, int k) {
		char temp = cArray[j];
		cArray[j] = cArray[k];
		cArray[k] = temp;
	}

	private static void printCharArray(char[] cArray) {
		StringBuilder builder = new StringBuilder();
		for (char i : cArray) {
			builder.append(i+" ");
		}
		System.out.println(builder.toString());
	}

}
