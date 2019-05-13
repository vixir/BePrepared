package com.vixir.beprepared.graph;

import java.util.LinkedList;

//UnDirected Graph implementation
public class Graph {

	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	// create a graph with empty edges
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

	/**
	 * @param v vertex of the Graph
	 * @return return degree i.e, number of nodes directly connected to given vertex
	 */
	public int degree(int v) {
		return adj[v].size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(V + " Vertices, " + E + " Edges.\n");
		for (int v = 0; v < V; v++) {
			builder.append(v + " ");
		}
		builder.append("\n");
		return builder.toString();
	}
}
