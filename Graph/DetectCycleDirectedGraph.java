
// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
import java.util.*;

class Solution {
    // Using Kahn's Algo
    // TC: O(V + E), SC: O(V)
    public static boolean isCyclicBFSDirected(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for (int u = 0; u < V; ++u)
            for (int v : adj.get(u))
                ++indegree[v];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; ++i)
            if (indegree[i] == 0)
                q.add(i);

        int count = 0;

        while (!q.isEmpty()) {
            int u = q.remove();
            ++count;
            for (int v : adj.get(u)) {
                --indegree[v];
                if (indegree[v] == 0)
                    q.add(v);
            }
        }

        return count != V;
    }

    // TC: O(V + E), SC: O(V)
    public static boolean isCyclicDFSDirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recSt = new boolean[V];

        for (int i = 0; i < V; ++i) {
            if (visited[i] == false)
                if (DFSRec(i, visited, recSt, adj))
                    return true;
        }
        return false;
    }

    public static boolean DFSRec(int node, boolean[] visited, boolean[] recSt, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        recSt[node] = true;

        for (int v : adj.get(node)) {
            if (visited[v] == false && DFSRec(v, visited, recSt, adj))
                return true;
            else if (recSt[v] == true)
                return true;
        }

        recSt[node] = false;
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
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
        if (isCyclicDFSDirected(V, graph))
            System.out.print("Cycle exists");
        else
            System.out.print("Cycle doesn't exists");
    }
}