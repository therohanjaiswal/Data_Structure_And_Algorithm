// https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
class Solution {
    // TC: O(n), SC: O(n)
    public static int countStringsNaive(String s) {
        int n = s.length();
        int[][] dp = new int[3][n + 1];
        dp[0][0] = dp[1][0] = dp[2][0] = 0;

        for (int i = 1; i < n + 1; ++i) {
            if (s.charAt(i - 1) == 'a') {
                dp[0][i] = 2 * dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1];
                dp[2][i] = dp[2][i - 1];
            } else if (s.charAt(i - 1) == 'b') {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = (2 * dp[1][i - 1] + dp[0][i - 1]);
                dp[2][i] = dp[2][i - 1];
            } else {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1];
                dp[2][i] = 2 * dp[2][i - 1] + dp[1][i - 1];
            }
        }

        return dp[2][n];
    }

    // TC: O(n), SC: O(1)
    public static int countStringsEfficient(String s) {
        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') {
                a = 2 * a + 1;
            } else if (s.charAt(i) == 'b') {
                ab = 2 * ab + a;
            } else if (s.charAt(i) == 'c') {
                abc = 2 * abc + ab;
            }
        }

        return abc;
    }

    public static void main(String[] args) {
        String str = "abbc";
        System.out.println("Count of subsequences: " + countStringsNaive(str));
        System.out.println("Count of subsequences: " + countStringsEfficient(str));
    }
}