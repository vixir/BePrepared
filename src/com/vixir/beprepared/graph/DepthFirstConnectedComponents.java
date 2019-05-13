package com.vixir.beprepared.graph;

/**
 * Depth First search to find out :
 * 1) whether two vertices are connected or not
 * 2) Number of total vertices in the cluster connected to the given vertex
 * 3) Can be used to find out number of different clusters by iterating over all the vertices
 */
public class DepthFirstConnectedComponents {
	private boolean[] marked;
	private int count;
	private Graph G;

	public DepthFirstConnectedComponents(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph g, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int getCount() {
		return count;
	}

}
