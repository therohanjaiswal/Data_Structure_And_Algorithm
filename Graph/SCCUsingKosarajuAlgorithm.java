
// https://www.geeksforgeeks.org/strongly-connected-components/
// Kosaraju Algorithm
import java.util.*;

class Solution {

    // TC: O(V + E), performs 3 traversals of the graph
    public static int stronglyConnectedComp(ArrayList<ArrayList<Integer>> adj, int V) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSRecToFillOrder(i, st, adj, visited);

        ArrayList<ArrayList<Integer>> reverseGraph = reverseEdges(adj);

        Arrays.fill(visited, false);

        int count = 0;
        while (!st.isEmpty()) {
            int i = st.pop();
            if (visited[i] == false) {
                findStrongComponents(i, reverseGraph, visited);
                System.out.println();
                ++count;
            }

        }
        return count;
    }

    public static void findStrongComponents(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int v : adj.get(i))
            if (visited[v] == false)
                findStrongComponents(v, adj, visited);
    }

    public static void DFSRecToFillOrder(int i, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {
        visited[i] = true;
        for (int v : adj.get(i))
            if (visited[v] == false)
                DFSRecToFillOrder(v, st, adj, visited);
        st.push(i);
    }

    public static ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < adj.size(); ++i)
            rev.add(new ArrayList<>());

        for (int i = 0; i < adj.size(); ++i) {
            for (int j = 0; j < adj.get(i).size(); ++j) {
                int v = adj.get(i).get(j);
                rev.get(v).add(i);
            }
        }
        return rev;
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
        addDirectedEdge(adj, 1, 0);
        addDirectedEdge(adj, 0, 2);
        addDirectedEdge(adj, 2, 1);
        addDirectedEdge(adj, 0, 3);
        addDirectedEdge(adj, 3, 4);
        System.out.print("Total strongly connected components: " + stronglyConnectedComp(adj, V));
    }
}