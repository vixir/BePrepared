package com.vixir.beprepared.graph;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 */

import java.util.*;

class GraphSearch {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[][] input = new int[N][M];
    }

    class Graph {

        private final int V;
        private int E;
        private LinkedList<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int v, int w) {
            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public int degree(int v) {
            return adj[v].size();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(V + " Vertices, " + E + " Edges.\n");
            for (int v = 0; v < V; v++) {
                builder.append(v + ": ");
                for (int w : adj[v]) {
                    builder.append(w + " ");
                }
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    /**
     * Repeat until the queue is empty
     * remove vertex v from the queue
     * Add to queue all unmarked vertices adjacent to v and mark them
     */
    class BreadthFirstPaths {
        private Queue<Integer> queue;
        private int[] edgeTo;
        private boolean[] marked;
        private final int s;

        public BreadthFirstPaths(Graph G, int s) {
            marked = new boolean[G.V()];
            this.s = s;
            edgeTo = new int[G.V()];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(s);
            marked[s] = true;
            while (!queue.isEmpty()) {
                int v = queue.remove();
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        queue.add(w);
                        marked[w] = true;
                        edgeTo[w] = v;
                    }
                }
            }

        }

    }

    class DepthFirstPaths {
        private boolean[] marked; // marked[v] = is there an s-v path?
        private int[] edgeTo; // edgeTo[v] = last edge on s-v path
        private final int s; // source vertex

        public DepthFirstPaths(Graph G, int s) {
            this.s = s;
            edgeTo = new int[G.V()];
            marked = new boolean[G.V()];
            dfs(G, s);
        }

        // depth first search from v
        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                    marked[w] = false;
                }
            }

        }

        public boolean hasPathTo(int v) {
            return marked[v];
        }

        public Iterable<Integer> pathTo(int v) {
            if (!hasPathTo(v))
                return null;
            Deque<Integer> path = new ArrayDeque<Integer>();
            for (int x = v; x != s; x = edgeTo[x])
                path.push(x);
            path.push(s);
            return path;
        }
    }
}
