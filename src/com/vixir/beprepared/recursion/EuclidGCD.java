package com.vixir.beprepared.recursion;

/**
 * For Euclid algorithm we have 2 steps
 * a) GCD(a,b) = GCD(b, a%b)
 * b) GDD(a,0) = a; // base condition
 */
public class EuclidGCD {

    public static void main(String[] args) {
        System.out.println(GCD(2, 4));
        System.out.println(GCD(3, 5));
    }

    public static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return GCD(y, x % y);
    }
}
