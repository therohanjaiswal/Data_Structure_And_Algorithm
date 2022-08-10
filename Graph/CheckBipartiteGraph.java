
// https://www.geeksforgeeks.org/bipartite-graph/
import java.util.*;

class Solution {
    // TC: O(V + E), SC: O(V)
    public static boolean isBipartiteDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] colorArr = new int[V];
        int color = 0;

        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                // if dfs returns false, means graph is not bipartite
                if (!dfs(adj, i, -1, visited, colorArr, color))
                    return false;
            }
        }

        return true;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, int parent, boolean[] visited,
            int[] colorArr, int color) {
        visited[curr] = true;
        colorArr[curr] = parent != -1 ? 1 - colorArr[parent] : color;

        for (int v : adj.get(curr)) {
            if (!visited[v]) {
                if (!dfs(adj, v, curr, visited, colorArr, color))
                    return false;
            } // v is visited and have same color as u, then graph is not bipartite
            else if (colorArr[v] == colorArr[curr]) {
                return false;
            }
        }

        return true;
    }

    // TC: O(V + E), SC: O(V)
    public static boolean isBipartiteBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] colorArr = new int[V];
        int color = 0;

        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                // if bfs returns false, means graph is not bipartite
                if (!bfs(adj, i, visited, colorArr, color))
                    return false;
            }
        }

        return true;
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int[] colorArr,
            int color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        colorArr[src] = color;

        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                    colorArr[v] = 1 - colorArr[u];
                } // v is visited and have same color as u, then graph is not bipartite
                else if (colorArr[v] == colorArr[u]) {
                    return false;
                }
            }
        }

        return true;
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
        addEdge(graph, 0, 3);
        addEdge(graph, 0, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 1, 3);
        if (isBipartiteBFS(V, graph))
            System.out.print("Graph is bipartite");
        else
            System.out.print("Graph is not bipartite");
    }
}