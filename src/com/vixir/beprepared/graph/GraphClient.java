package com.vixir.beprepared.graph;

import java.util.Deque;

/**
 * Client class to test Graph utility functions
 */
public class GraphClient {

	public static void main(String... args) {
		Graph graph = new Graph(10);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 6);
		graph.addEdge(3, 6);
		graph.addEdge(6, 9);
		graph.addEdge(4, 7);
		graph.addEdge(4, 8);
		graph.addEdge(7, 8);
		graph.addEdge(8, 9);
		System.out.println(graph);
		DepthFirstPaths paths = new DepthFirstPaths(graph, 1);
		Deque<Integer> pathTo = (Deque<Integer>) paths.pathTo(9);
		for (int i : pathTo) {
			System.out.print(i + " ");
		}
	}

}
