// https://www.geeksforgeeks.org/length-of-the-longest-alternating-even-odd-subarray/
class Solution {
    // TC: O(n^2), SC: O(1)
    public static int maxOddEvenNaive(int[] arr) {
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] % 2 != 0 && arr[j - 1] % 2 == 0) || (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0))
                    ++curr;
                else
                    break;
            }
            maxSubarray = Math.max(maxSubarray, curr);
        }
        return maxSubarray;
    }

    // Based of Kadane'salgorithm. TC:O(n), SC: O(1)
    public static int maxOddEvenEfficient(int[] arr) {
        int maxSubarray = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 != 0 && arr[i - 1] % 2 == 0) || (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)) {
                ++curr;
                maxSubarray = Math.max(maxSubarray, curr);
            } else
                curr = 1;

        }
        return maxSubarray;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 6, 3, 8 };
        int result = maxOddEvenEfficient(arr);
        System.out.println(result);
    }
}
