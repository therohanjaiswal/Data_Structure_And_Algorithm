// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    // nums will contain number from 1 to n+1
    // No negative numbers.
    // TC: O(n), SC: O(1)
    public static int findDuplicateEfficient(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int n = Math.abs(nums[i]);
            if (nums[n] < 0)
                return n;
            nums[n] = -nums[n];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 3, 4 };
        int res = findDuplicateEfficient(arr);
        System.out.println(res);
    }
}