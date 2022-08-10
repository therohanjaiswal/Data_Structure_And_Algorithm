// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
class Solution {
    // TC: O(logn), SC: O(run time stack)
    public static int lastOccurence(int[] arr, int x, int low, int high) {
        int n = arr.length;
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x)
                return lastOccurence(arr, x, low, mid - 1);
            else if (arr[mid] < x)
                return lastOccurence(arr, x, mid + 1, high);
            else {
                if (mid == n - 1 || arr[mid] != arr[mid + 1])
                    return mid;
                else
                    return lastOccurence(arr, x, mid + 1, high);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 20, 20, 30, 30, 40, 40, 40 };
        int x = 40;
        System.out.println(lastOccurence(arr, x, 0, arr.length - 1));
    }
}
