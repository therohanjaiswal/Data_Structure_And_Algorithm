
// https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
// Bellmanford Algorithm
import java.util.*;

class Solution {

    // TC: O(V*E)
    public static int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < edges.length; ++j) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[v] > (dist[u] + wt))
                    dist[v] = dist[u] + wt;
            }
        }

        for (int j = 0; j < edges.length; ++j) {
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            if (dist[u] != Integer.MAX_VALUE && dist[v] > (dist[u] + wt))
                return 1;
        }
        return 0;
    }

    public static int[][] makeEdgeMatrix(ArrayList<ArrayList<Pair>> adj, int V) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            for (Pair p : adj.get(i)) {
                int v = p.v;
                int wt = p.wt;
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(v);
                arr.add(wt);
                edges.add(arr);
            }
        }
        int[][] edgeMatrix = new int[edges.size()][3];
        for (int i = 0; i < edges.size(); ++i) {
            edgeMatrix[i][0] = edges.get(i).get(0);
            edgeMatrix[i][1] = edges.get(i).get(1);
            edgeMatrix[i][2] = edges.get(i).get(2);
        }

        return edgeMatrix;
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Pair>> adj, int i, int j, int wt) {
        adj.get(i).add(new Pair(j, wt));
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
        addDirectedEdge(adj, 0, 1, -1);
        addDirectedEdge(adj, 1, 2, -2);
        addDirectedEdge(adj, 2, 0, -3);
        int[][] edges = makeEdgeMatrix(adj, V);
        if (isNegativeWeightCycle(V, edges) == 1)
            System.out.print("Negative cycle exists.");
        else
            System.out.print("Negative cycle do not exists.");
    }
}

class Pair {
    int v, wt;

    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}