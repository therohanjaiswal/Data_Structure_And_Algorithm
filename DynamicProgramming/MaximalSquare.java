// https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
class Solution {
    // TC: O(n*m), SC: O(n*m)
    public static int maxSqaure(int n, int m, int[][] matrix) {
        int[][] dp = new int[n + 1][m + 1];
        int largest = 0;

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1 },
                { 1, 1 } };
        int n = 2, m = 2;
        int maxSq = maxSqaure(n, m, mat);
        System.out.println(maxSq);
    }
}