// https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
class Solution {
    // TC: O(n^2), SC: O(n)
    public static int longestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n]; // longest increasing subsequence
        int[] lds = new int[n]; // longest decreasing subsequence
        // lis[i] = longest increasing subsequence ending at i
        // lds[i] = longest decreasing subsequence starting from i
        lis[0] = 1;
        lds[n - 1] = 1;
        for (int i = 1; i < n; ++i) {
            int max = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] < nums[i])
                    max = Math.max(max, lis[j]);
            }
            lis[i] = 1 + max;
        }

        for (int i = n - 1; i >= 0; --i) {
            int max = 0;
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] < nums[i])
                    max = Math.max(max, lds[j]);
            }
            lds[i] = 1 + max;
        }

        int max = 0;
        for (int i = 0; i < n; ++i)
            max = Math.max(max, lis[i] + lds[i] - 1);

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println("Longest Increasing subsequence: " + longestBitonicSequence(nums));
    }
}