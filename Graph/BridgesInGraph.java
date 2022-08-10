
// https://www.geeksforgeeks.org/bridge-in-a-graph/
import java.util.*;

class Solution {

    static int time = 0;

    // Uses Tarjans Algorithm
    // TC: O(V + E), performs 1 traversal of the graph
    public static ArrayList<ArrayList<Integer>> bridgesUsingTarjan(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int u = 0; u < V; ++u)
            if (disc[u] == -1)
                DFS(adj, u, disc, low, parent, bridges);

        return bridges;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int u, int[] disc, int[] low, int[] parent,
            ArrayList<ArrayList<Integer>> bridges) {
        disc[u] = low[u] = time++;

        for (Integer v : adj.get(u)) {
            if (disc[v] == -1) { // if v is not visited
                parent[v] = u;
                DFS(adj, v, disc, low, parent, bridges);
                low[u] = Math.min(low[u], low[v]);

                // bridge found
                if (low[v] > disc[u]) {
                    ArrayList<Integer> bridge = new ArrayList<>();
                    bridge.add(u);
                    bridge.add(v);
                    bridges.add(bridge);
                }
            }
            // if v is already visited and it is not the parent of u
            // means there is a back edge u -> v, and hence don't disconnect the graph
            else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
        addEdge(adj, 1, 0);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 3, 4);
        ArrayList<ArrayList<Integer>> bridges = bridgesUsingTarjan(adj, V);
        System.out.println("Bridges: ");
        for (int i = 0; i < bridges.size(); ++i)
            System.out.println(bridges.get(i).get(0) + " - " + bridges.get(i).get(1));
    }
}