// https://www.geeksforgeeks.org/binary-search/
class Solution {
    // TC: O(logn), SC: O(1)
    public static int recursiveBinarySearch(int[] arr, int x, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                return recursiveBinarySearch(arr, x, mid + 1, high);
            else
                return recursiveBinarySearch(arr, x, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        int x = 50;
        System.out.println(x + " present at index " + recursiveBinarySearch(arr, x, 0, arr.length - 1));
    }
}
