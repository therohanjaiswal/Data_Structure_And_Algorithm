
// https://www.youtube.com/watch?v=eTaWFhPXPz4
import java.util.*;

class Solution {
    // TC: O(V)
    public static int find(int node, int[] parent) {
        if (parent[node] == node)
            return node;
        return find(parent[node], parent);
    }

    // TC: O(V)
    public static void union(int src, int dest, int[] parent) {
        int parentOfSrc = find(src, parent);
        int parentOfDest = find(dest, parent);
        parent[parentOfSrc] = parentOfDest;
    }

    // TC: O(E * V), works only for undirected graph
    public static boolean isCyclicUnionFind(int V, ArrayList<Edge> edges) {
        int[] parent = new int[V];
        for (int i = 0; i < V; ++i)
            parent[i] = i;

        for (Edge e : edges) {
            int headOfSrc = find(e.src, parent);
            int headOfDest = find(e.dest, parent);
            if (headOfDest == headOfSrc)
                return true;
            union(e.src, e.dest, parent);
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
        if (isCyclicUnionFind(V, graph))
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