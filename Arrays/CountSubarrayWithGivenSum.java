// https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
class Solution {
    // TC: O(n), SC: O(n)
    public int countSubarr(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (preSum.containsKey(sum - k))
                res += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { -5, 8, -14, 2, 4, 12 };
        int n = arr.length;
        int k = -5;
        System.out.println(countSubarr(arr, k));
    }
}