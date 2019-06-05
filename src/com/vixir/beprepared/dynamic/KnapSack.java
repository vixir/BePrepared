package com.vixir.beprepared.dynamic;

public class KnapSack {

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int r = knapSackDp(val, wt, 50);
        System.out.println(r);
    }

    private static int knapSackDp(int[] val, int[] wt, int max) {
        int[][] t = new int[wt.length + 1][max + 1];
        for (int row = 0; row <= wt.length; row++) {
            for (int col = 0; col <= max; col++) {
                if (row == 0 || col == 0) {
                    t[row][col] = 0;
                } else if (wt[row - 1] <= col) {
                    int a = t[row - 1][col - wt[row - 1]] + val[row - 1];
                    int b = t[row - 1][col];
                    t[row][col] = Math.max(a, b);
                } else {
                    t[row][col] = t[row - 1][col];
                }
            }
        }
        return t[wt.length][max];
    }

}
