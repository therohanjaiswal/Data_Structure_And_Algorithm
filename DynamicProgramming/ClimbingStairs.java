import java.util.Arrays;

// https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2
class Solution {

    // We have to count the number of paths from n to 0
    // from n, one can either n-1 or n-2 or n-3
    // ways(n) = number of ways to reach 0 from n
    // ways(n) = ways(n-1) + ways(n-2) + ways(n-3)
    // TC: O(n), SC: O(n)
    public static int countPaths(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // number of paths from 0 to 0 is 1;

        for (int i = 1; i < n + 1; ++i) {
            if (i == 1)
                dp[i] = dp[i - 1];
            else if (i == 2)
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // TC: O(n), SC: O(n)
    public static int countPathsMemoized(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int nminus1 = countPathsMemoized(n - 1, dp);
        int nminus2 = countPathsMemoized(n - 2, dp);
        int nminus3 = countPathsMemoized(n - 3, dp);
        dp[n] = nminus1 + nminus2 + nminus3;
        return dp[n];
    }

    public static void main(String[] args) {
        int N = 8;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println("Total paths count: " + countPathsMemoized(N, dp));
        System.out.println("Total paths count: " + countPaths(N));
    }
}