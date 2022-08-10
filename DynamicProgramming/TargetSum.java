// https://www.geeksforgeeks.org/number-of-ways-to-calculate-a-target-number-using-only-array-elements/

class Solution {
    // TC: O(N * |sum of array elements|), SC: O(N * |sum of array elements|)
    public static int targetSum(int arr[], int n, int target) {
        int sum = 0;
        for (int x : arr)
            sum += x;
        if ((target + sum) % 2 != 0)
            return 0;
        int s1 = (target + sum) / 2;

        // if s2 is greater than make s1 = s2
        // sum-s1 is s2 only
        if (sum - s1 > s1)
            s1 = sum - s1;

        int dp[][] = new int[n + 1][s1 + 1];
        for (int i = 0; i < s1 + 1; i++)
            dp[0][i] = 0;
        dp[0][0] = 1;

        // here j starts with 0
        // as the first column is not initialized as it not 1 in all rows,
        // it is computed in the loop
        // edge case : arr[0, 0, 0, 0, 0, 0, 0, 0, 1], target = 1, n = 9.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < s1 + 1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][s1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 1, 1 };
        int n = arr.length;
        int target = 5;
        System.out.println("Number of Subsets with given target sum: " + targetSum(arr, n, target));
    }
}