
// https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
import java.util.*;

class Solution {
    // TC: O(logV)
    public static int find(int node, int[] parent) {
        if (parent[node] == node)
            return node;
        parent[node] = find(parent[node], parent);
        return parent[node]; // path compression
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

    // TC: O(E * logV), works only for undirected graph
    public static boolean isCyclicPathCompression(int V, ArrayList<Edge> edges) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (Edge e : edges) {
            int parentOfSrc = find(e.src, parent); // finds absolute parent of src
            int parentOfDest = find(e.dest, parent); // finds absolute parent of dest

            if (parentOfSrc == parentOfDest)
                return true;

            union(e.src, e.dest, parent, rank);
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>(V);
        graph.add(new Edge(0, 1));
        graph.add(new Edge(0, 2));
        graph.add(new Edge(1, 2));
        graph.add(new Edge(2, 3));
        graph.add(new Edge(1, 3));
        if (isCyclicPathCompression(V, graph))
            System.out.print("Cycle exists");
        else
            System.out.print("Cycle doesn't exists");
    }
}

class Edge {
    int src, dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}