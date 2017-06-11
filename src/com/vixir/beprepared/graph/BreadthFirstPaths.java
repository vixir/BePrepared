package com.vixir.beprepared.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean marked[];
	private int[] edgeTo;
	private int[] distTo;
	private Graph G;
	private final int s;

	public BreadthFirstPaths(Graph G, int s) {
		this.s = s;
		this.G = G;
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.E()];
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = INFINITY;
		}
		distTo[s] = 0;
		marked[s] = true;
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.offer(w);
				}
			}
		}
	}

}
