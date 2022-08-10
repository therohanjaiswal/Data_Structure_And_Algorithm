
// https://www.geeksforgeeks.org/hamiltonian-cycle-backtracking-6/?ref=lbp
import java.util.*;

class Solution {
    // TC: O(n!), SC: O(n + m)
    public boolean checkHamPath(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; ++i)
            adj.add(new ArrayList<>());

        for (ArrayList<Integer> sub : Edges) {
            int src = sub.get(0);
            int dest = sub.get(1);
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; ++i) {
            if (!visited[i] && DFS(adj, i, N, visited, 1))
                return true;
        }

        return false;
    }

    boolean DFS(ArrayList<ArrayList<Integer>> adj, int src, int N, boolean[] visited, int counter) {
        if (counter == N)
            return true;

        for (Integer v : adj.get(src)) {
            if (isSafe(v, visited)) {
                visited[src] = true;
                if (DFS(adj, v, N, visited, counter + 1))
                    return true;
                visited[src] = false;
            }
        }

        return false;
    }

    boolean isSafe(int v, boolean[] visited) {
        if (!visited[v])
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No of edges: ");
        int m = scanner.nextInt();
        System.out.print("No of vertices: ");
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        System.out.println("Enter edges one by one: ");
        for (int i = 0; i < m; ++i) {
            ArrayList<Integer> edge = new ArrayList<>();
            System.out.print("Enter src: ");
            int src = scanner.nextInt();
            System.out.print("Enter dest: ");
            int dest = scanner.nextInt();
            edge.add(src);
            edge.add(dest);
            edges.add(edge);
        }

        Solution sol = new Solution();
        System.out.println(sol.checkHamPath(n, m, edges));
    }
}