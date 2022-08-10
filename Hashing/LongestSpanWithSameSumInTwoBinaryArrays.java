
// https://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(1)
    public static int longestCommonSumNaive(boolean[] arr1, boolean[] arr2) {
        int res = 0;
        for (int i = 0; i < arr1.length; ++i) {
            int sum1 = 0, sum2 = 0;
            for (int j = i; j < arr2.length; ++j) {
                sum1 += arr1[j] ? 1 : 0;
                sum2 += arr2[j] ? 1 : 0;

                if (sum1 == sum2)
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }

    // TC: O(n), SC: O(n)
    public static int longestCommonSumEfficient(boolean arr1[], boolean arr2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr1.length;
        int prefixSum = 0;
        int[] temp = new int[n];
        int maxLen = 0;

        // store the difference. Here diff = 0 means both the array same sum
        // temp[i] = 1, when arr1[i] = 1 and arr2[i] = 0
        // temp[i] = -1, when arr1[i] = 0 and arr2[i] = 1
        // sequence of temp [..,-1,1,..] means sum is zero taking arr1 and arr2
        for (int i = 0; i < n; ++i)
            temp[i] = (arr1[i] ? 1 : 0) - (arr2[i] ? 1 : 0);

        for (int i = 0; i < n; ++i) {
            prefixSum += temp[i];

            if (prefixSum == 0)
                maxLen = Math.max(maxLen, i + 1);

            if (map.containsKey(prefixSum))
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            else
                map.put(prefixSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        boolean[] arr1 = { false, true, false, false, false, false };
        boolean[] arr2 = { true, false, true, false, false, true };
        System.out.print(longestCommonSumNaive(arr1, arr2));
        System.out.println(longestCommonSumEfficient(arr1, arr2));
    }
}
