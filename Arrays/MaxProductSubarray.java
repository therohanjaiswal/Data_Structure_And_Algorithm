
// https://www.geeksforgeeks.org/maximum-product-subarray/
class Solution {
    // TC: O(n^2), SC: O(1)
    public static int maxProductSubarrayNaive(int[] arr) {
        int result = Integer.MIN_VALUE;
        int product;
        for (int i = 0; i < arr.length; ++i) {
            product = 1;
            for (int j = i; j < arr.length; ++j) {
                product *= arr[j];
                result = Math.max(result, product);
            }
        }
        return result;
    }

    // TC: O(n), SC: O(1)
    public static int maxProductSubarrayEfficient(int[] arr) {
        int currMin = 1, currMax = 1;
        int res = Integer.MIN_VALUE;

        for (int n : arr) {
            int temp = currMax;
            currMax = Math.max(n * currMax, Math.max(n * currMin, n));
            // currMax is stored in temp as currMax is updated in previous line
            currMin = Math.min(n * temp, Math.min(n * currMin, n));
            res = Math.max(res, currMax);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 6, -3, -10, 0, 2 };
        System.out.println(maxProductSubarrayNaive(arr));
        System.out.println(maxProductSubarrayEfficient(arr));
    }
}
