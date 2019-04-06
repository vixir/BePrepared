package com.vixir.beprepared.mst;

import java.util.Comparator;
import java.util.Random;

public class Edge implements Comparator<Edge> {
    private Integer a;
    private Integer b;
    private int w;
    private final Random RANDOM = new Random();

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

    @Override
    public int compare(Edge o1, Edge o2) {
        return java.lang.Integer.compare(o1.w, o2.w);
    }

    /**
     * @param obj not a good implementation, but gets the task done
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        return this.w == ((Edge) obj).w;
    }
}
