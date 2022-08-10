
// https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
import java.util.*;

class DFS {
    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, ArrayList<Integer> dfs) {
        visited[s] = true;
        dfs.add(s);
        for (int u : adj.get(s)) {
            if (visited[u] == false) {
                DFSRec(adj, u, visited, dfs);
            }
        }
    }

    // TC: O(V + E), SC: O(V)
    public static int connectedComponenetsDFS(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                DFSRec(adj, i, visited, dfs);
                ++count;
            }
        }

        System.out.println("DFS Traversal: " + dfs);
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
        System.out.print("Total connected components: " + connectedComponenetsDFS(graph, V));
    }
}