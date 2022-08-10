// https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

class Solution {
    // TC: O(N * |sum of array elements|), SC: O(N * |sum of array elements|)
    public static int findMinDiff(int arr[], int n) {
        int range = 0;
        for (int a : arr)
            range += a;

        boolean[][] dp = new boolean[n + 1][range + 1];
        for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < range + 1; ++j) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < range + 1; ++j) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j = range / 2; j >= 0; --j) {
            if (dp[n][j]) {
                minDiff = Math.min(minDiff, range - 2 * j);
                break;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;
        System.out.println("The minimum difference between 2 sets is " + findMinDiff(arr, n));
    }
}