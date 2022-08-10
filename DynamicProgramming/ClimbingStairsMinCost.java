// https://leetcode.com/problems/min-cost-climbing-stairs/
class Solution {
    // TC: O(n), SC: O(n)
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; --i)
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println("Minimum cost: " + minCostClimbingStairs(cost));
    }
}