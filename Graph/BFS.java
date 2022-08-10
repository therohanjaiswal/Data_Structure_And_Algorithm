
// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
import java.util.*;

class Solution {
    public static void BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, ArrayList<Integer> bfs) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.remove();
            bfs.add(u);
            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    // TC: O(V + E), SC: O(V)
    public static int connectedComponenetsBFS(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                BFS(adj, i, visited, bfs);
                ++count;
            }
        }

        System.out.println("BFS Traversal: " + bfs);
        return count;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
        g.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            graph.add(new ArrayList<>());
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        System.out.print("Total connected components: " + connectedComponenetsBFS(graph, V));
    }
}