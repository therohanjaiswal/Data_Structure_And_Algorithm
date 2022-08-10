
// https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
import java.util.*;

class Solution {

    // TC: O(V + E), SC: O(V)
    public static void shortestPath(ArrayList<ArrayList<Integer>> adj, int V, int s) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    visited[v] = true;
                }
            }
        }

        for (int d : dist)
            System.out.print(d + " ");
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
        g.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            graph.add(new ArrayList<>());
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 1, 3);
        shortestPath(graph, V, 0);
    }
}