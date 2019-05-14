package com.vixir.beprepared.mst;

import java.util.Comparator;
import java.util.Random;

public class Edge implements Comparable<Edge> {
    private Integer a;
    private Integer b;
    private int w;
    private static final Random RANDOM = new Random();

    public Edge(Integer a, Integer b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    public int weight() {
        return w;
    }

    public int either() {
        return RANDOM.nextBoolean() ? a : b;
    }

    public int other(int x) {
        if (x != a && x != b) {
            throw new IllegalArgumentException();
        }
        return x == a ? b : a;
    }

    /**
     * @param obj not a good implementation, but gets the job done
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return this.w == ((Edge) obj).w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}
