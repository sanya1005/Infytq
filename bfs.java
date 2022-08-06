import java.util.LinkedList;
import java.util.Queue;
public class Main {
	public static void main(String[] args) {
		int[][] graph = new int[][] {{1,4}, 
                                     {0, 2, 3, 4}, 
                                     {1, 3}, 
                                     {1, 2, 4}, 
                                     {0, 1, 3}};
		BFS(graph);
        BFS2(graph);
		return ;
	}
	public static void BFS(int[][] graph) {
		boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int curr = queue.poll();
                    if(!visited[curr]) {
                        System.out.println(curr);
                        visited[curr] = true;
                        for(int next : graph[curr]) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
    }
    public static void BFS2(int[][] graph) {
		boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int curr = queue.poll();
                    System.out.println(curr);
                    for(int next : graph[curr]) {
                        if(!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }
	}
}
