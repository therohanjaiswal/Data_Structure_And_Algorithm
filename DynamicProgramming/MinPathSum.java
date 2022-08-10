// https://www.youtube.com/watch?v=BzTIOsC0xWM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=7
class Solution {
    // TC: O(m*n), SC: O(m*n)
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // each cell denotes the min cost required from that cell to rightmost
        // bottommost cell
        // from each grid cell either we can go right or down
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                // for rightmost bottommost cell, the cost to reach that cell is same as
                // grid[m-1][n-1]
                if (i == m - 1 && j == n - 1)
                    dp[i][j] = grid[i][j];
                // for last row, it has only way possible which is to go right and cost will be
                // cost of grid[i][j] + cost to reach rightmost bottommost cell from
                // grid[i][j+1] which is stored in dp[i][j+1]
                else if (i == m - 1)
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                // for last col, it has only way possible which is to go down and cost will be
                // cost of grid[i][j] + cost to reach rightmost bottommost cell from
                // grid[i+1][j] which is stored in dp[i+1][j]
                else if (j == n - 1)
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                // for every other cell, it has usual 2 ways i.e., down and right
                else
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println("Minimum cost: " + minPathSum(grid));
    }
}