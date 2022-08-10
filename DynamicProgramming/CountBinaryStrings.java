// https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
class Solution {
    // TC: O(n), SC: O(n)
    public static int countStringsEfficient(int n) {
        if (n == 1)
            return 1;

        int endWith0 = 1;
        int endWith1 = 1;
        for (int i = 2; i < n + 1; ++i) {
            // here, storing endwith0 into temp to store previous value of
            // endWith0 as endWith0 is updated after that and it is used in endWith1
            int temp = endWith0;
            endWith0 = endWith1;
            endWith1 = temp + endWith1;
        }

        return endWith0 + endWith1;
    }

    // TC: O(n), SC: O(n)
    public static long countStringsNaive(int n) {
        long[][] dp = new long[2][n + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < n + 1; ++i) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
        }

        return dp[0][n] + dp[1][n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countStringsNaive(n));
        System.out.println(countStringsEfficient(n));
    }
}
