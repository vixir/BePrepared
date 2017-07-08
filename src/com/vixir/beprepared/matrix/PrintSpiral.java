package com.vixir.beprepared.matrix;

public class PrintSpiral {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };
		printSpiral(a);
	}

	private static void printSpiral(int[][] a) {

		int row = a.length;
		if (0 == row) {
			System.out.println("Can not print this.");
		}
		row = row - 1;
		int col = a[0].length - 1;
		int mr = 0, mc = 0;
		int direction = 1;
		while (((mr <= row) && (col >= 0) && (row >= 0) && (col >= mc))) {
			switch (direction) {
			case 1: {
				for (int i = mc; i <= col; i++) {
					System.out.print(a[mr][i] + " ");
				}
				mr++;
				direction = 2;
			}
				if (mr > row) {
					break;
				}
			case 2: {
				for (int i = mr; i <= row; i++) {
					System.out.print(a[i][col] + " ");
				}
				col--;
				direction = 3;
			}
				if (col < 0) {
					break;
				}
			case 3: {
				for (int i = col; i >= mc; i--) {
					System.out.print(a[row][i] + " ");
				}
				row--;
				direction = 4;
			}
				if (row < 0) {
					break;
				}
			case 4: {
				for (int i = row; i >= mr; i--) {
					System.out.print(a[i][mc] + " ");
				}
				mc++;
				direction = 1;
			}
				if (mc > col) {
					break;
				}
			}
		}
	}

}
