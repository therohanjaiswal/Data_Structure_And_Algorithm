//  https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
class Solution {
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

    // TC: O(logn), SC: O(1)
    public static int countOccurences(int[] arr, int x) {
        int firstOcc = firstOccurence(arr, x, 0, arr.length - 1);
        if (firstOcc == -1)
            return 0;
        return (lastOccurence(arr, x, 0, arr.length - 1) - firstOcc + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        // int[] arr = { 10, 10, 10, 10, 10, 10, 10 }; Edge case.
        int x = 5;
        System.out.println("Number of occurences of " + x + " are " + countOccurences(arr, x));
    }
}
