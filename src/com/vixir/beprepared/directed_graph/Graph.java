package com.vixir.beprepared.directed_graph;

import java.util.*;
import java.util.stream.*;

/**
 * Directed Graph implementation with topological sort
 */
public class Graph {
    private Integer V;   // No. of vertices
    private LinkedList[] adj; // Adjacency List

    Graph(Integer v) {
        V = v;
        adj = new LinkedList[v];
        IntStream.range(0, V).forEach(i -> adj[i] = new LinkedList<Integer>());

    }

    // Function to add an edge into the graph
    void addEdge(Integer v, Integer w) {
        adj[v].add(w);
    }

    /**
     * Topological sorted array
     */
    public Deque<Integer> topologicalSort() {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] marked = new boolean[V];
        IntStream.range(0, V).forEach(i -> marked[i] = false);
        IntStream.range(0, V).forEach(i -> {
            if (!marked[i]) {
                topologicalUtil(stack, marked, i);
            }
        });
        return stack;
    }

    /**
     * @param v vertex to be passed
     * @return direct vertices connected to given vertex
     */
    public Iterable<Integer> adj(Integer v) {
        return adj[v];
    }

    /**
     * @param stack  stack to store the vertices in topological sorted manner
     * @param marked boolean array to keep track of traversed vertices
     * @param i      vertex
     */
    private void topologicalUtil(Deque<Integer> stack, boolean[] marked, Integer i) {
        marked[i] = true;
        Iterable<Integer> iterable = adj(i);
        iterable.forEach(k -> {
            if (!marked[k]) {
                topologicalUtil(stack, marked, k);
            }
        });

        // push element into stack if it is fully explored
        stack.push(i);
    }
}
