package com.vixir.beprepared.dynamic;

public class EditDistance {

	public static void main(String[] args) {
		String a = "abcda";
		String b = "abcdabcd";
		System.out.println(editDistance(a, b, a.length(), b.length()));
	}

	public static int editDistance(String a, String b, int x, int y) {
		int[][] changes;
		changes = new int[x + 1][y + 1];
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				if (i == 0) {
					changes[i][j] = j;
				} else if (j == 0) {
					changes[i][j] = i;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					changes[i][j] = changes[i - 1][j - 1];
				} else {
					changes[i][j] = 1 + getMin(changes[i][j - 1], changes[i - 1][j], changes[i - 1][j - 1]);
				}
			}
		}
		return changes[x][y];
	}

	private static int getMin(int i, int j, int k) {
		int smallest = i;
		if (j < smallest) {
			smallest = j;
		}
		if (k < smallest) {
			smallest = k;
		}
		return smallest;
	}
}
