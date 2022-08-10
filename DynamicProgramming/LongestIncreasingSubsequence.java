// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
class Solution {
    // TC: O(n^2), SC: O(n)
    public static int lengthOfLISDp(int[] nums) {
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

        return result;
    }

    // TC: O(nlogn), SC: O(n)
    public static int lengthOfLISBinarySearch(int[] nums) {
        int n = nums.length;
        int[] tailTable = new int[n];
        int len; // always points empty slot
        tailTable[0] = nums[0];
        len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < tailTable[0])
                // new smallest value
                tailTable[0] = nums[i];

            else if (nums[i] > tailTable[len - 1])
                // nums[i] wants to extend largest subsequence
                tailTable[len++] = nums[i];

            else
                // nums[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, nums[i])] = nums[i];
        }

        return len;
    }

    // Binary search (note boundaries in the caller)
    // nums[] is ceilIndex in the caller
    public static int CeilIndex(int nums[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (nums[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println("Longest Increasing subsequence: " + lengthOfLISDp(nums));
        System.out.println("Longest Increasing subsequence: " + lengthOfLISBinarySearch(nums));
    }
}