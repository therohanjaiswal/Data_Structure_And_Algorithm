
// https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
import java.util.*;

class Solution {
    // TC: O(logV)
    public static int find(int node, int[] parent) {
        if (parent[node] == node)
            return node;
        parent[node] = find(parent[node], parent);
        return parent[node];
    }

    // TC: O(logV)
    public static void union(int src, int dest, int[] parent, int[] rank) {
        int parentOfSrc = find(src, parent);
        int parentOfDest = find(dest, parent);

        // case 1: if both have different rank
        if (rank[parentOfSrc] > rank[parentOfDest]) { // src has higher rank
            parent[parentOfDest] = parentOfSrc;
        } else if (rank[parentOfSrc] < rank[parentOfDest]) { // dest has higher rank
            parent[parentOfSrc] = parentOfDest;
        } else { // case 2: if both have same rank, then anyone can be made as parent
            parent[parentOfSrc] = parentOfDest;
            rank[parentOfSrc]++;
        }
    }

    // TC: O(ELogV), SC: O(V)
    public static ArrayList<Edge> krushkal(int V, int E, ArrayList<Edge> edges) {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        ArrayList<Edge> mst = new ArrayList<>();
        int mstWeight = 0;
        for (Edge e : edges) {
            int parentOfSrc = find(e.src, parent);
            int parentOfDest = find(e.dest, parent);
            if (parentOfSrc != parentOfDest) {
                mstWeight += e.weight;
                mst.add(e);
                union(e.src, e.dest, parent, rank);
            }
        }

        System.out.println("Minimum spanning tree weight: " + mstWeight);
        return mst;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
        g.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        ArrayList<Edge> graph = new ArrayList<>(V);
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 6));
        graph.add(new Edge(0, 3, 5));
        graph.add(new Edge(1, 3, 15));
        graph.add(new Edge(2, 3, 4));

        ArrayList<Edge> mst = krushkal(V, E, graph);
        if (mst.isEmpty()) {
            System.out.println("MST not possible");
            return;
        }

        for (Edge e : mst)
            System.out.println(e.src + " -> " + e.dest + " , " + e.weight);
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
