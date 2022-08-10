// https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
class Solution {
    // TC: O(n), SC: o(n)
    private static int maximumSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = arr[0];

        for (int i = 2; i < n + 1; ++i) {
            dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 5, 10, 100, 10, 5 };
        System.out.println(maximumSum(arr));
    }
}