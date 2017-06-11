package com.vixir.beprepared.graph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	private Graph G;

	public DepthFirstSearch(Graph G, int s) {
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
