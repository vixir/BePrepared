package com.vixir.beprepared.general;

public class MergedRectangleArea {
/*

    Find the total area covered by two rectilinear rectangles in a 2D plane.

    Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

                |-------------------|(G,H)
                |                   |
     ___________|____(C,D)          |
    |      (E,F)|____|__________ ___|
    |                |
    |                |
 (A,B)----------------
*/

    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int xIntersection = intersectionLength(A, E, C, G);
        int yIntersection = intersectionLength(B, F, D, H);
        int areaIntersection = xIntersection * yIntersection;
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        return areaA + areaB - areaIntersection;
    }

    private static int intersectionLength(int startPointA, int startPointB, int endPointA, int endPointB) {
        int maxStartPoint = Math.max(startPointA, startPointB);
        int minEndPoint = Math.min(endPointA, endPointB);
        System.out.println(maxStartPoint + " " + minEndPoint);
        if (maxStartPoint < minEndPoint) {
            return minEndPoint - maxStartPoint;
        }
        return 0;
    }

}
