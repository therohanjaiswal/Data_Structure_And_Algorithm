// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
class Solution {
    // TC: O(n*k^2), SC: O(n*k)
    public static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        // i = number of eggs, j = jth floor
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < k + 1; ++j) {
                if (i == 1)
                    dp[i][j] = j;
                else if (j == 1)
                    dp[i][j] = 1;
                else {
                    int min = Integer.MAX_VALUE;
                    for (int x = j - 1, y = 0; x >= 0; --x, ++y) {
                        int val1 = dp[i][x]; // my row, egg survives
                        int val2 = dp[i - 1][y]; // previous row, egg breaks
                        int val = Math.max(val1, val2);
                        min = Math.min(min, val);
                    }

                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.println("Min attempts to find critical floor: " + eggDrop(n, k));
    }
}