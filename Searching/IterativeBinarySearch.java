// https://www.geeksforgeeks.org/binary-search/
class Solution {
    // TC: O(logn), SC: O(1)
    public static int iterativeBinarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        int x = 50;
        System.out.println(x + " present at index " + iterativeBinarySearch(arr, x));
    }
}
