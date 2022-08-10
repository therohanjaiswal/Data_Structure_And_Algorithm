// https://leetcode.com/discuss/interview-question/1271034/count-no-of-subsets-with-given-difference-dp

class Solution {
    // TC: O(N * |sum of array elements|), SC: O(N * |sum of array elements|)
    public static int countWithGivenSum(int arr[], int n, int diff) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        int reqSum = (diff + sum) / 2;
        return subsetSum(arr, n, reqSum);
    }

    public static int subsetSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3 };
        int n = arr.length;
        int diff = 1;
        System.out.println("Number of Subsets with given diff " + countWithGivenSum(arr, n, diff));
    }
}