// https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/

class Solution {
    // TC: O(logn), SC: O(1)
    public static int findPeak(int[] arr, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1]))
                return mid;
            else if (mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 20, 40, 30, 20, 50, 60 };
        System.out.println("Peak element present at: " + findPeak(arr, arr.length));
    }
}
