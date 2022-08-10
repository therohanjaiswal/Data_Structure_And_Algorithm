// https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
class Solution {
    public static boolean findPair(int[] arr, int low, int high, int sum) {
        while (low < high) {
            int currSum = arr[low] + arr[high];
            if (currSum == sum)
                return true;
            if (currSum > sum)
                --high;
            else
                ++low;
        }
        return false;
    }

    // Two Pointer Approach, TC: O(n^2), SC: O(1)
    // if the array is unsorted then sort the array which requires O(nlogn) only
    // then TC: O(nlogn + n^2) = O(n^2)
    public static boolean findTriplet(int[] arr, int sum) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (findPair(arr, i + 1, n - 1, sum - arr[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 8, 9, 20, 40 };
        int sum = 32;
        System.out.println(findTriplet(arr, sum));
    }
}
