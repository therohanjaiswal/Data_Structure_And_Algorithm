
// https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(1)
    public static int longestSubarrayNaive(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            int ones = 0, zeros = 0;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] == 1)
                    ++ones;
                if (arr[j] == 0)
                    ++zeros;
                if (ones == zeros)
                    result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }

    // TC: O(n), SC: O(n)
    public static int longestSubarrayEfficient(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, result = 0;
        for (int i = 0; i < N; ++i) {
            if (arr[i] == 1)
                sum += 1;
            else
                sum -= 1;
            if (sum == 0)
                result = Math.max(result, i + 1);

            if (map.containsKey(sum))
                result = Math.max(result, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 1, 0 };
        System.out.println(longestSubarrayNaive(arr));
        System.out.println(longestSubarrayEfficient(arr));
    }
}
