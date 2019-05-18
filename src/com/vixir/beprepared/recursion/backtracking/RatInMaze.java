package com.vixir.beprepared.recursion.backtracking;

public class RatInMaze {

    int[][] solution;

    public RatInMaze(int N) {
        solution = new int[N][N];
    }

    public void solveMaze(int[][] maze, int N) {
        if (findPath(maze, 0, 0, N, Direction.DOWN)) {
            print(solution);
        } else {
            System.out.println("Maze not Solvable.");
        }
    }

    private boolean findPath(int[][] maze, int row, int col, int N, Direction dir) {
        if (row == N - 1 && col == N - 1) {
            solution[row][col] = 1;
            return true;
        }
        if (isValidMove(maze, row, col, N)) {
            solution[row][col] = 1;

            if (dir != Direction.UP && findPath(maze, row + 1, col, N, Direction.DOWN)) {
                return true;
            }
            if (dir != Direction.LEFT && findPath(maze, row, col + 1, N, Direction.RIGHT)) {
                return true;
            }
            if (dir != Direction.RIGHT && findPath(maze, row, col - 1, N, Direction.LEFT)) {
                return true;
            }
            if (dir != Direction.DOWN && findPath(maze, row - 1, col, N, Direction.UP)) {
                return true;
            }
            solution[row][col] = 0;
            return false;
        }

        return false;

    }

    private boolean isValidMove(int[][] maze, int row, int col, int n) {
        if (row >= 0 && col >= 0 && row < n && col < n && maze[row][col] != 0) {
            return true;
        }
        return false;
    }

    public void print(int[][] solution) {
        int N = solution.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + solution[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] maze = {{1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 0, 1, 1},
                {1, 0, 1, 1, 1}};

        RatInMaze r = new RatInMaze(N);
        System.out.println("Original Maze:");
        r.print(maze);
        System.out.println("Solution:");
        r.solveMaze(maze, N);
    }

}

enum Direction {
    DOWN, UP, LEFT, RIGHT;
}