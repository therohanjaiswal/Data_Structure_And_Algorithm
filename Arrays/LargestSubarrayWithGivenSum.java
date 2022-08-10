
// https://www.geeksforgeeks.org/longest-sub-array-sum-k/
import java.util.HashMap;

class Solution {
    // TC: O(n), SC: O(n)
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(sum))
                map.put(sum, i);

            // check if 'sum-k' is present in 'map' or not
            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i - map.get(sum - k));
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { -5, 8, -14, 2, 4, 12 };
        int n = arr.length;
        int k = -5;
        System.out.println(lenOfLongSubarr(arr, n, k));
    }
}