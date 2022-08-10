// https://www.geeksforgeeks.org/minimum-number-deletions-make-sorted-sequence/
class Solution {
    // TC: O(n^2), SC: O(n)
    public static int minDeletions(int[] nums) {
        int n = nums.length;
        // dp[i] = longest increasing subsequence ending with arr[i-1]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int result = dp[1];
        for (int i = 2; i < n + 1; ++i) {
            int max = 0;
            for (int j = i - 1; j > 0; --j) {
                if (nums[j - 1] < nums[i - 1])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = 1 + max;
            result = Math.max(result, dp[i]);
        }

        return n - result;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println("Minimum deletions: " + minDeletions(nums));
    }
}