package com.vixir.beprepared.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensList {

    private static final String BLANK = ".";
    private static final String QUEEN = "Q";

    public static void nQueen(int n) {
        nQueen(new ArrayList<>(), 0, n);
    }

    private static void nQueen(List<Integer> columnPositions, int n, int N) {
        if (n == N) {
            generateBoard(columnPositions);
        } else {
            for (int col = 0; col < N; col++) {
                columnPositions.add(col);
                if (isValid(columnPositions, n)) {
                    nQueen(columnPositions, n + 1, N);
                }
                columnPositions.remove(columnPositions.size() - 1);
            }
        }
    }

    private static void generateBoard(List<Integer> columnPositions) {
        int size = columnPositions.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (columnPositions.get(i) == j) {
                    System.out.print(QUEEN);
                } else {
                    System.out.print(BLANK);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValid(List<Integer> util, int n) {
        for (int i = 0; i < n; i++) {
            if ((util.get(i) - util.get(n)) == 0) return false;
            if ((util.get(n) - util.get(i)) == (i - n)) return false;
            if ((util.get(i) - util.get(n)) == (i - n)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        nQueen(4);
    }

}
