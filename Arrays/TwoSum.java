
// https://leetcode.com/problems/two-sum/
import java.util.*;

class Solution {
    // TC:O(n), SC: O(n)
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[1] = i;
                res[0] = map.get(diff);
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 6, 9, 7 };
        int target = 7;
        int[] res = twoSum(arr, target);
    }
}