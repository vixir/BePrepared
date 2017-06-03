package com.vixir.beprepared.dynamic;

public class EggDrop {

	public static void main(String[] args) {
		System.out.println(eggDrop(100, 2));
	}

	public static int eggDrop(int floors, int eggs) {
		int[][] sol = new int[eggs + 1][floors + 1];
		int c = 0;
		for (int i = 0; i <= floors; i++) {
			sol[1][i] = i;
		}
		for (int row = 2; row <= eggs; row++) {
			for (int column = 1; column <= floors; column++) {
				sol[row][column] = Integer.MAX_VALUE;
				for (int k = 1; k <= column; k++) {
					c = 1 + Math.max(sol[row - 1][k - 1], sol[row][column - k]);
					if (c < sol[row][column]) {
						sol[row][column] = c;
					}
				}
			}
		}
		return sol[eggs][floors];
	}

}
