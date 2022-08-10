// https://www.geeksforgeeks.org/edit-distance-dp-5/

class Solution {
    // TC: O(m*n), SC: O(m*n)
    public static int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                if (i == 0)
                    dp[i][j] = j;
                if (j == 0)
                    dp[i][j] = i;
            }
        }

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], // delete from s1
                            Math.min(dp[i][j - 1], // insert into s1
                                    dp[i - 1][j - 1])); // replace in s1
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "cat";
        String word2 = "cut";
        System.out.println("Minimum operation required: " + editDistance(word1, word2));
    }
}