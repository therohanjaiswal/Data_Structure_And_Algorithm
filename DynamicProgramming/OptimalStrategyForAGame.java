
// https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
class Solution {
    // TC: O(n^2), SC: O(n^2)
    public static long countMaximum(int arr[], int n) {
        long[][] dp = new long[n][n];

        // gap iteration helps to fill the table diagonally
        for (int gap = 0; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                if (gap == 0)
                    dp[i][j] = arr[i];
                else if (gap == 1)
                    dp[i][j] = Math.max(arr[i], arr[j]);
                else
                    dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                            arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 7, 10 };
        System.out.println("Max score: " + countMaximum(arr, arr.length));
    }
}