package graph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class Dfs {
	private Graph graph;
	private int source;
	private boolean[] marked;
	private int[] edgeTo;
	public Dfs(Graph graph, int source) {
		this.graph = graph;
		this.source = source;
		this.marked = new boolean[graph.getVertices()];
		this.edgeTo = new int[graph.getVertices()];
	}
	private void dfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(source);
		marked[source] = true;
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			List<Integer> items = graph.getAdj(v);
			for (int w : items) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					queue.offer(w);
				}
			}
		}
	}
	public Stack<Integer> pathTo(int v) {
		if (!marked[v]) return null
		Stack<Integer> stack = new Stack<>();
		int x = v;
		while (x != source) {
			stack.push(x);
			x = edgeTo[x];
		}
		stack.push(source);
		return stack;
	}
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0,1);
		graph.addEdge(0,3);
		graph.addEdge(0,4);
		graph.addEdge(1,2);
		graph.addEdge(2,5);
		graph.addEdge(3,4);
		graph.addEdge(3,5);
		graph.printGraph();
		Dfs dfs = new Dfs(graph, 0);
		dfs.dfs();
		Stack<Integer> integers = dfs.pathTo(5);
		System.out.println(integers);
	}
}
