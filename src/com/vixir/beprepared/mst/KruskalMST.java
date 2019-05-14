package com.vixir.beprepared.mst;

import java.util.*;
import java.util.stream.*;

public class KruskalMST {

    private Queue<Edge> mst = new LinkedList<>();

    public KruskalMST(EdgeWeightedGraph graph) {
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        graph.edges().forEach(edges::add);
        UnionFind unionFind = new UnionFind(graph.V());
        while (!edges.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = edges.poll();
            int v = e.either(), w = e.other(v);
            if (!unionFind.connected(w, v)) {
                unionFind.union(w, v);
                mst.add(e);
            }
        }
    }

    public Iterable<Edge> mstEdges() {
        return mst;
    }

}

/**
 *
 */
class UnionFind {

    private int[] id;
    private int[] rank;

    public UnionFind(int n) {
        id = new int[n];
        rank = new int[n];
        IntStream.range(0, n).forEach(x -> id[x] = x);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (rank[i] < rank[j]) id[i] = j;
        else if (rank[j] > rank[j]) id[j] = i;
        else {
            id[i] = j;
            rank[j]++;
        }
    }
}