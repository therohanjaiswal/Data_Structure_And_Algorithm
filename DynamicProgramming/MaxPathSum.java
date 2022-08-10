// https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1#

class Solution {
    // TC: O(N*N), SC: O(N*N)
    public static int maximumPath(int N, int Matrix[][]) {
        // from grid[r,c], we can go to grid[r+1][c-1] or grid[r+1, c] or grid[r+1][c+1]
        // each cell denotes the maximum path sum from that cell to bottom row
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = Matrix[N - 1][N - 1];

        // for last row, we have no way possible as we have already reached bottom
        // so last row will be same as matrix
        for (int j = N - 2; j >= 0; --j)
            dp[N - 1][j] = Matrix[N - 1][j];

        for (int i = N - 2; i >= 0; --i) {
            for (int j = N - 1; j >= 0; --j) {
                // for last col, we have only 2 way possible i.e., [r+1, c] and [r+1, c-1]
                if (j == N - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - 1]) + Matrix[i][j];
                }
                // for first col, we have only 2 way possible i.e., [r+1][c] and [r+1, c+1]
                else if (j == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + Matrix[i][j];
                }
                // for every other cell we have all 3 ways available
                else {
                    dp[i][j] = Math.max(Math.max(dp[i + 1][j], dp[i + 1][j + 1]), dp[i + 1][j - 1]) + Matrix[i][j];
                }
            }
        }

        // we will take the maximum value from first row
        int maxPathSum = Integer.MIN_VALUE;
        for (int j = 0; j < N; ++j)
            maxPathSum = Math.max(dp[0][j], maxPathSum);

        return maxPathSum;
    }

    public static void main(String[] args) {
        int N = 2;
        int[][] grid = { { 348, 391 }, { 618, 193 } };
        System.out.println("Minimum cost: " + maximumPath(N, grid));
    }
}