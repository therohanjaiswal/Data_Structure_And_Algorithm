
// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
// Tarjens Algorithm
import java.util.*;

class Solution {

    static int time = 0;

    // TC: O(V + E), performs 1 traversal of the graph
    public static boolean[] articulationPoints(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] isAP = new boolean[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int u = 0; u < V; ++u)
            if (disc[u] == -1)
                DFS(adj, u, disc, low, parent, isAP);

        return isAP;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int u, int[] disc, int[] low, int[] parent,
            boolean[] isAP) {
        disc[u] = low[u] = time++;
        int children = 0;

        for (Integer v : adj.get(u)) {
            if (disc[v] == -1) { // if v is not visited
                ++children;
                parent[v] = u;
                DFS(adj, v, disc, low, parent, isAP);
                low[u] = Math.min(low[u], low[v]);

                // case 1: u is root node(parent[u] == -1) and have more than 1 children
                if (parent[u] == -1 && children > 1)
                    isAP[u] = true;

                // case 2: u is not root node and has back edge
                if (parent[u] != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            }
            // if v is already visited and it is not the parent of u
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
        boolean[] isAP = articulationPoints(adj, V);
        System.out.println("Articulation Points: ");
        for (int i = 0; i < isAP.length; ++i)
            if (isAP[i])
                System.out.println(i);
    }
}