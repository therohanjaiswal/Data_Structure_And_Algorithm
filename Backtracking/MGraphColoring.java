//https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
class Solution {
    public static void main(String[] args) {
        boolean[][] graph = { { false, true, true, true },
                { true, false, true, false },
                { true, true, false, true },
                { true, false, true, false } };
        int m = 3, n = 4;
        Solution sol = new Solution();
        System.out.println(sol.graphColoring(graph, m, n));
    }

    // TC: O(m^n), SC: O(n)
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];

        if (solve(graph, color, 0, m, n))
            return true;

        return false;
    }

    public boolean solve(boolean[][] graph, int[] color, int node, int m, int n) {
        if (node == n) {
            return true;
        }

        for (int i = 1; i <= m; ++i) {
            if (isSafe(node, graph, color, i, n)) {
                color[node] = i;
                if (solve(graph, color, node + 1, m, n))
                    return true;
                color[node] = 0;
            }
        }

        return false;
    }

    public boolean isSafe(int node, boolean[][] graph, int[] color, int col, int n) {
        for (int i = 0; i < n; ++i)
            if (graph[node][i] && color[i] == col)
                return false;

        return true;
    }
}