package com.vixir.beprepared.mst;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Spanning Tree : Graph contains minimum number of edges and all vertices
 * Minimum Spanning Tree: Total weight of sum of the edges must be minimum
 */
public class PrimMST {

    private double weight;       // total weight of MST
    private Queue<Edge> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private PriorityQueue<Edge> pq;      // edges with one endpoint in tree


    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     *
     * @param G the edge-weighted graph
     */
    public PrimMST(EdgeWeightedGraph G) {
        mst = new LinkedList<Edge>();
        pq = new PriorityQueue<Edge>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)      // run from each vertex to find  c minimum spanning forest
            if (!marked[v]) {
                prim(G, v);
            }
    }

    // run Prim's algorithm in graph G, starting from vertex s
    private void prim(EdgeWeightedGraph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.add(e);
            weight += e.weight();
            if (!marked[v]) scan(G, v);
            if (!marked[w]) scan(G, w);
        }

    }

    // scan vertex v, add minimum weighted edge to priority queue, if not already marked
    private void scan(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) {
                pq.add(e);
            }
        }
    }

    /**
     * @return the edges in a minimum spanning tree as
     * an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * @return Returns the sum of the edge weights in a minimum spanning tree (or forest).
     */
    public double weight() {
        return weight;
    }

}
