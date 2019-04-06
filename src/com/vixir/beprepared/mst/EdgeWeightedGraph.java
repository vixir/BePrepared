package com.vixir.beprepared.mst;

import java.util.*;

public class EdgeWeightedGraph {

    private static final String NEWLINE = "\n";
    private final Integer V;
    private int E;
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int[] v, int[] e, int[] w) {
        this.V = v.length;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Edge>();
        }
    }

    public int E() {
        return E;
    }

    public int V() {
        return V;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

}
