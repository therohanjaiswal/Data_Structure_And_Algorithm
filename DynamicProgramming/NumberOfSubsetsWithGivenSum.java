// https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
class Solution {
    // TC: O(N * Sum), SC: O(N * Sum)
    public static int isSubsetSum(int N, int arr[], int sum) {
        int[][] dp = new int[N + 1][sum + 1];

        // Initialization
        for (int i = 0; i < N + 1; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < sum + 1; ++j) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[N][sum];
    }

    public static void main(String[] args) {
        int N = 6, sum = 9;
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int res = isSubsetSum(N, arr, sum);
        System.out.println(res);
    }
}