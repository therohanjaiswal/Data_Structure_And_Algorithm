
// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/
import java.util.*;

class Solution {

    static int time = 0;

    // Tarjans Algorithm
    // TC: O(V + E), performs 1 traversal of the graph
    public static ArrayList<ArrayList<Integer>> SCCTarjan(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> scc = new ArrayList<>();
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] presentInStack = new boolean[V];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int u = 0; u < V; ++u)
            if (disc[u] == -1)
                DFS(adj, u, disc, low, st, presentInStack, scc);

        Collections.sort(scc, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return scc;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int u, int[] disc, int[] low, Stack<Integer> st,
            boolean[] presentInStack, ArrayList<ArrayList<Integer>> scc) {
        disc[u] = low[u] = time++;
        st.push(u);
        presentInStack[u] = true;

        for (Integer v : adj.get(u)) {
            if (disc[v] == -1) { // if v is not visited
                DFS(adj, v, disc, low, st, presentInStack, scc);
                low[u] = Math.min(low[u], low[v]);
            } // if v is already visited, then may be u -> v is back edge or cross edge
            else if (presentInStack[v]) // if v is present in stack then u -> v is back edge
                low[u] = Math.min(low[u], disc[v]);
        }

        if (low[u] == disc[u]) { // if u is head node of SCC
            ArrayList<Integer> arr = new ArrayList<>();
            while (st.peek() != u) {
                arr.add(st.peek());
                presentInStack[st.pop()] = false;
            }
            arr.add(st.peek());
            presentInStack[st.pop()] = false;
            Collections.sort(arr);
            scc.add(arr);
        }
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
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
        ArrayList<ArrayList<Integer>> scc = SCCTarjan(adj, V);
        System.out.println("Strongly connected componenets: ");
        for (int i = 0; i < scc.size(); ++i)
            System.out.println(scc.get(i));
    }
}