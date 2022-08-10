// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
class Solution {
    // TC: O(logn), SC: O(1)
    public static int firstOccurenceIterative(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else if (mid > 0 && arr[mid] == arr[mid - 1])
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    // TC: O(logn), SC: O(run time stack)
    public static int firstOccurenceRecursive(int[] arr, int x, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x)
                return firstOccurence1(arr, x, low, mid - 1);
            else if (arr[mid] < x)
                return firstOccurence1(arr, x, mid + 1, high);
            else {
                if (mid == 0 || arr[mid] != arr[mid - 1])
                    return mid;
                else
                    return firstOccurence1(arr, x, low, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int x = 5;
        System.out.println(firstOccurence1(arr, x, 0, arr.length - 1));
    }
}
