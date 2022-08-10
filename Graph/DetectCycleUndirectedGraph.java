
// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
import java.util.*;

class Solution {
    // TC: O(V + E), SC: O(V)
    public static boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false)
                if (bfsDetect(i, parent, visited, adj))
                    return true;
        }
        return false;
    }

    public static boolean bfsDetect(int node, int[] parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        parent[node] = -1;

        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                } else if (parent[u] != v) // v is visited but v is not parent of u, then cycle exists
                    return true;
            }
        }
        return false;
    }

    // TC: O(V + E), SC: O(V)
    public static boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                // -1 denotes the parent of ith node
                if (dfsDetect(i, -1, visited, adj))
                    return true;
            }
        }

        return false;
    }

    public static boolean dfsDetect(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (visited[v] == false) {
                if (dfsDetect(v, node, visited, adj))
                    return true;
            } else if (v != parent) // v is already visited and is not parent of node, then cycle exists
                return true;
        }
        return false;
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
        if (isCycleDFS(V, graph))
            System.out.print("Cycle exists");
        else
            System.out.print("Cycle doesn't exists");
    }
}