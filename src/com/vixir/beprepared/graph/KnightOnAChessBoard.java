package com.vixir.beprepared.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Knight(Horse) movement on a chess board
 *
 * Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.
 * Knight cannot go out of the board.
 * If yes, then what would be the minimum number of steps for the knight to move to the said point.
 */
public class KnightOnAChessBoard {

    boolean marked[][];
    Queue<Square> queue = new LinkedList<>();

    public int knight(int A, int B, int C, int D, int E, int F) {
        marked = new boolean[A + 1][B + 1];
        queue.add(new Square(C, D, 0));
        marked[C][D] = true;

        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};


        while (!queue.isEmpty()) {
            Square v = queue.poll();
            if (v.x == E && v.y == F) {
                return v.dist;
            }
            for (int i = 0; i < 8; i++) {
                int posX = v.x + dx[i];
                int posY = v.y + dy[i];
                if (isPossible(posX, posY, A, B) && !marked[posX][posY]) {
                    marked[posX][posY] = true;
                    queue.add(new Square(posX, posY, v.dist + 1));
                }
            }
        }
        return -1;

    }

    private boolean isPossible(int x, int y, int R, int C) {
        return (x > 0 && x <= R && y > 0 && y <= C);
    }

    class Square {
        int x, y;
        int dist;

        public Square(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
