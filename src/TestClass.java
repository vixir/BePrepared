
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class TestClass {
	public static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n <= 2)
			return true;
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static ArrayList<Boolean> getPrimeNumbers(int number) {
		ArrayList<Boolean> primeNumbers = new ArrayList();
		for (int i = 0; i <= number; i++) {
			if (isPrime(i)) {
				primeNumbers.add(true);
			} else {
				primeNumbers.add(false);
			}
		}
		return primeNumbers;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String args[]) throws Exception {

		FastReader s = new FastReader();
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] input = new int[N][M];
		Graph graph = new Graph(N * M);
		int current;
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Boolean> primeNumbers = getPrimeNumbers(100000);
		long currentTimeMillis = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				input[i][j] = s.nextInt();
				current = input[i][j];
				if (primeNumbers.get(current)) {
					if ((i - 1 >= 0) && (j - 1 >= 0) && primeNumbers.get(input[i - 1][j - 1])) {
						graph.addEdge(getIndex(i - 1, j - 1, M), getIndex(i, j, M));
					}
					if (i - 1 >= 0 && primeNumbers.get(input[i - 1][j])) {
						graph.addEdge(getIndex(i - 1, j, M), getIndex(i, j, M));
					}
					if (j - 1 >= 0 && primeNumbers.get(input[i][j - 1])) {
						graph.addEdge(getIndex(i, j - 1, M), getIndex(i, j, M));
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Bokachoda" + (end - currentTimeMillis));
		DepthFirstPaths paths = new DepthFirstPaths(graph, 0, N * M - 1);
		int sol = paths.getNumberOfPaths();
		System.out.println(sol);
		System.out.println("Bokachoda" + (System.currentTimeMillis() - end));
		if (sol > 0) {
			StringBuilder builder = new StringBuilder();
			for (Integer i : paths.getPathFinal()) {
				builder.append(getMatrix(i, M) + "\n");
			}
			System.out.println(builder.toString());
		}
		System.out.println("Bokachoda" + (System.currentTimeMillis() - end));
	}

	private static String getMatrix(int i, int m) {
		StringBuilder builder = new StringBuilder();
		int k = (i % m) + 1;
		return builder.append(i / m + 1 + " " + k).toString();
	}

	private static int getIndex(int i, int j, int m) {
		if (i > 0) {
			return i * m + j;
		}
		return j;
	}
}

class Item {
	int i;
	int j;
	int w;
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
			builder.append(v + " ");
		}
		builder.append("\n");
		return builder.toString();
	}
}

class DepthFirstPaths {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int s;
	private int count;// source vertex
	private Deque<Integer> pathFinal = new ArrayDeque<>();
	private int dest;

	public DepthFirstPaths(Graph G, int s, int dest) {
		this.s = s;
		this.dest = dest;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		count = 0;
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		marked[v] = true;
		if (v == dest) {
			count++;
			pathFinal.clear();
			for (Integer i : pathTo(v)) {
				pathFinal.add(i);
			}
		}
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
				marked[w] = false;
			}
		}

	}

	public Iterable<Integer> getPathFinal() {
		return pathFinal;
	}

	public int getNumberOfPaths() {
		return count;
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
