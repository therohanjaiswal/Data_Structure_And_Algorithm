// https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
class Solution {
    // TC: O(n*n), SC: O(1)
    public static int findMaxDiffNaive(int[] arr) {
        if (arr.length == 1)
            return -1;

        int res = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; ++i)
            for (int j = i + 1; j < arr.length; ++j)
                res = Math.max(arr[j] - arr[i], res);

        return res;
    }

    // TC: O(n), SC: O(1)
    public static int findMaxDiffEfficient(int[] arr) {
        // if array is sorted in increasing order then max diff = arr[n-1] - arr[0]
        // but in case of sorted in decreasing order it is not arr[0] - arr[n-1]
        // as j should be greater than i
        // for eg: In int[] arr = {30, 10, 8, 2} max diff is 8 - 10 = -2, not 30 - 2 =
        // 28
        int curr_min = arr[0];
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff = Math.max(diff, arr[i] - curr_min);
            curr_min = Math.min(curr_min, arr[i]);
        }

        return diff;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
        int[] arr = { 30, 10, 8, 2 };
        int result = findMaxDiffEfficient(arr);
        System.out.println(result);
    }
}
