
// Kahn's Algorithm
// https://www.geeksforgeeks.org/topological-sorting/
import java.util.*;

class Solution {
    // TC: O(V + E), SC: O(V)
    public static int[] topologicalSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSRec(i, visited, st, adj);

        int[] topoSort = new int[V];
        int index = 0;
        while (!st.isEmpty())
            topoSort[index++] = st.pop();

        return topoSort;
    }

    public static void DFSRec(int u, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (visited[v] == false)
                DFSRec(v, visited, st, adj);
        }
        st.push(u);
    }

    // TC: O(V + E), SC: O(V)
    public static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] res = new int[V];
        int[] indegree = new int[V];
        for (int u = 0; u < V; ++u)
            for (int v : adj.get(u))
                ++indegree[v];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; ++i)
            if (indegree[i] == 0)
                q.add(i);

        int index = 0;
        while (!q.isEmpty()) {
            int u = q.remove();
            res[index++] = u;
            for (int v : adj.get(u)) {
                --indegree[v];
                if (indegree[v] == 0)
                    q.add(v);
            }
        }
        return res;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
        addEdge(adj, 5, 2);
        addEdge(adj, 5, 0);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        System.out.print("Topological Sort: ");
        int[] topoSort = topologicalSortDFS(V, adj);
        for (int i : topoSort)
            System.out.print(i + " ");
    }
}