package com.vixir.beprepared.mst;

import java.util.*;

public class EdgeWeightedGraph {

    /**
     * Vertices
     */
    private final Integer V;
    /**
     * Edges
     */
    private int E;
    /**
     * Adjacency list
     */
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
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

    /**
     * @param edges Add edges from an array
     */
    private void addEdges(Edge[] edges) {
        for (Edge e : edges) {
            this.addEdge(e);
        }
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * @param args Test client to test MST
     */
    public static void main(String[] args) {
        Edge e1 = new Edge(0, 7, 16);
        Edge e2 = new Edge(2, 3, 17);
        Edge e3 = new Edge(1, 7, 19);
        Edge e4 = new Edge(0, 2, 26);
        Edge e5 = new Edge(5, 7, 28);
        Edge e6 = new Edge(1, 3, 29);
        Edge e7 = new Edge(1, 5, 32);
        Edge e8 = new Edge(2, 7, 34);
        Edge e9 = new Edge(4, 5, 35);
        Edge e10 = new Edge(1, 2, 36);
        Edge e11 = new Edge(4, 7, 37);
        Edge e12 = new Edge(0, 4, 38);
        Edge e13 = new Edge(6, 2, 40);
        Edge e14 = new Edge(3, 6, 52);
        Edge e15 = new Edge(6, 0, 58);

        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(15);
        Edge[] edges = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15};
        edgeWeightedGraph.addEdges(edges);
        PrimMST primMST = new PrimMST(edgeWeightedGraph);
        System.out.println("Minimum weight for the graph is " + primMST.weight());
    }
}
