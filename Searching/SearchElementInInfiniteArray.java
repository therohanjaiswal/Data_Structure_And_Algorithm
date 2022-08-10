// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

class Solution {
    public static int binarySearch(int[] arr, int x, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x)
                return binarySearch(arr, x, low, mid - 1);
            else if (arr[mid] < x)
                return binarySearch(arr, x, mid + 1, high);
            else
                return mid;
        }
        return -1;
    }

    // TC: O(logn), SC: O(1)
    public static int findPos(int[] arr, int x) {
        int low = 0;
        if (arr[low] == x)
            return low;

        int high = 1;
        while (arr[high] < x) {
            low = high;
            if (2 * high < arr.length - 1)
                high = 2 * high;
            else
                high = arr.length - 1;
        }
        return binarySearch(arr, x, low, high);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
        int x = 10;
        int pos = findPos(arr, x);
        if (pos == -1)
            System.out.println("Element not found!");
        else
            System.out.println("Element is present at index: " + pos);
    }
}
