// https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/

class Solution {
    // TC: O(n), SC: O(1)
    public static int getMaxSumEfficient(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return -1;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // TC: O(n.k), SC: O(1)
    public static int getMaxSumNaive(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 30, -5, 20, 7 };
        int k = 3;
        int result = getMaxSumEfficient(arr, k);
        System.out.println(result);
    }
}