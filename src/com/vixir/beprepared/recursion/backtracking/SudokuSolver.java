package com.vixir.beprepared.recursion.backtracking;

/**
 * Feeling sleepy. But a commit is a commit. Leetcode accepted solution
 */
public class SudokuSolver {
    private final static Character EMPTY_ENTRY = '.';

    public void solveSudoku(char[][] board) {
        solveSudokuCell(0, 0, board);
    }

    private boolean solveSudokuCell(int row, int col, char[][] board) {
        //edge cases
        if (col == board[row].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }

        if (board[row][col] != EMPTY_ENTRY) {
            return solveSudokuCell(row, col + 1, board);
        }

        for (int value = 1; value <= board.length; value++) {
            char newValue = (char) (value + '0');

            if (isValidPosition(board, row, col, newValue)) {
                board[row][col] = newValue;
                if (solveSudokuCell(row, col + 1, board)) {
                    return true;
                }
            }
        }
        board[row][col] = EMPTY_ENTRY;
        return false;
    }

    private boolean isValidPosition(char[][] board, int row, int col, Character newValue) {
        for (char[] rows : board) {
            if (newValue == rows[col]) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (newValue == board[row][i]) {
                return false;
            }
        }

        int regionSize = (int) Math.sqrt(board.length);

        int I = row / regionSize;
        int J = col / regionSize;

        int topLeftSubboxRow = I * regionSize;
        int topLeftSubboxColumn = J * regionSize;

        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (newValue == board[topLeftSubboxRow + i][topLeftSubboxColumn + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
