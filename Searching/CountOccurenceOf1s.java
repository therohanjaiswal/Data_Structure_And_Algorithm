// https://www.geeksforgeeks.org/count-1s-sorted-binary-array/

class Solution {
    // TC: O(logn), SC: O(1)
    public static int firstOccurence(int[] arr, int x, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x)
                return firstOccurence(arr, x, low, mid - 1);
            else if (arr[mid] < x)
                return firstOccurence(arr, x, mid + 1, high);
            else {
                if (mid == 0 || arr[mid] != arr[mid - 1])
                    return mid;
                else
                    return firstOccurence(arr, x, low, mid - 1);
            }
        }
        return -1;
    }

    public static int countOccurences(int[] arr) {
        int n = arr.length;
        int firstOcc = firstOccurence(arr, 1, 0, n - 1);
        if (firstOcc == -1)
            return 0;
        return n - firstOcc;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 1, 1, 1, 1 };
        System.out.println("Total occurences of 1's: " + countOccurences(arr));
    }
}
