// https://www.geeksforgeeks.org/partition-problem-dp-18/

class Solution {
    // TC: O(N * Sum), SC: O(N * Sum)
    public static int equalPartition(int N, int arr[]) {
        int sum = 0;

        for (int i : arr)
            sum += i;

        if (sum % 2 != 0)
            return 0;

        sum /= 2;

        boolean[][] dp = new boolean[N + 1][sum + 1];
        for (int i = 0; i < N + 1; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < sum + 1; ++j) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[N][sum] == true ? 1 : 0;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] arr = { 1, 5, 11, 5 };
        int res = equalPartition(N, arr);
        System.out.println(res);
    }
}