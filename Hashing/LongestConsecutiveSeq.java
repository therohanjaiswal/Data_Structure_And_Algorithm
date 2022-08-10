
// https://www.geeksforgeeks.org/longest-consecutive-subsequence/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(1)
    public static int longestSubNaive(int[] arr) {
        Arrays.sort(arr);
        int result = 0, len = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == (arr[i - 1] + 1))
                ++len;
            else {
                result = Math.max(result, len);
                len = 1;
            }
        }
        return result;
    }

    // TC: O(n), SC: O(n)
    public static int longestSubEfficient(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i)
            set.add(arr[i]);

        int res = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int currLen = 0;
                while (set.contains(i + currLen))
                    ++currLen;

                res = Math.max(res, currLen);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 9, 4, 3, 10 };
        System.out.println(longestSubNaive(arr));
        System.out.println(longestSubEfficient(arr));
    }
}