// https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/
class Solution {
    // TC: O(n^2), SC: O(1)
    public static int findMaxConsOnesNaive(int[] arr) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; ++i) {
            count = 0;
            int j = i;
            while (j < arr.length && arr[j] == 1) {
                ++count;
                ++j;
            }
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    // TC: O(n), SC: O(1)
    public static int findMaxConsOnesEfficient(int[] arr) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                ++count;
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        // this is required to handle cases where arr ends with 1
        // arr = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 };
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 };
        int result = findMaxConsOnesEfficient(arr);
        System.out.println("Max consecutive ones: " + result);
        System.out.println(findMaxConsOnesNaive(arr));
    }
}