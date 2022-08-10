
import java.util.*;

class Solution {
    // TC: O(V + E), SC: O(V)
    public static int[] shortestPathDAG(int V, ArrayList<ArrayList<AdjListNode>> adj, int s) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        int[] topoSort = topologicalSortDFS(V, adj);

        for (int u : topoSort) {
            for (AdjListNode v : adj.get(u)) {
                if (dist[v.getV()] > (dist[u] + v.getWeight()))
                    dist[v.getV()] = dist[u] + v.getWeight();
            }
        }

        return dist;
    }

    public static int[] topologicalSortDFS(int V, ArrayList<ArrayList<AdjListNode>> adj) {
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

    public static void DFSRec(int u, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<AdjListNode>> adj) {
        visited[u] = true;
        for (AdjListNode v : adj.get(u)) {
            if (visited[v.getV()] == false)
                DFSRec(v.getV(), visited, st, adj);
        }
        st.push(u);
    }

    public static void addEdge(ArrayList<ArrayList<AdjListNode>> adj, int u, int v, int wt) {
        adj.get(u).add(new AdjListNode(v, wt));
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<AdjListNode>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 5, 3, 1);

        int source = 0;
        int[] dist = shortestPathDAG(V, adj, source);
        System.out.print("Shortest Path DAG from source " + source + ": ");
        for (int d : dist)
            System.out.print(d + " ");
    }
}

class AdjListNode {
    private int v;
    private int weight;

    AdjListNode(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }
}
