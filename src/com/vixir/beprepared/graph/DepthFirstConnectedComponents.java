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

	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : this.G.adj(v)) {
			if (!marked[w]) {
				dfs(this.G, w);
			}
		}
	}

	/**
	 * @param v whether given vertex is connected to vertex passed in constructor
	 * @return true if connected i.e, part of a single cluster/tree, false if not connected
	 */
	public boolean marked(int v) {
		return marked[v];
	}

	/**
	 * @return count of the connected components for given node
	 */
	public int getCount() {
		return count;
	}

}
