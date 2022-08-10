// https://www.geeksforgeeks.org/longest-common-substring-dp-29/
class Solution {
    // TC: O(n*m), SC: O(n*m)
    public static int longestComSubstring(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int result = 0;

        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < m + 1; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int n = s1.length();
        int m = s2.length();
        System.out.println("Longest common substring length: " + longestComSubstring(s1, s2, n, m));
    }
}