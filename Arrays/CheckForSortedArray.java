// https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/
class Solution {
    // TC: O(n), SC: O(1)
    public static boolean isSortedIterative(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    // TC: O(n), SC: O(1)
    public static boolean isSortedRecursive(int[] arr, int n) {
        if (n == 1)
            return true;

        if (isSortedRecursive(arr, n - 1)) {
            if (arr[n - 1] < arr[n - 2])
                return false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 4, 5 };
        if (isSorted(arr))
            System.out.println("Array is sorted!");
        else
            System.out.println("Array is unsorted!");

        if (isSortedRecursive(arr, arr.length))
            System.out.println("Array is sorted!");
        else
            System.out.println("Array is unsorted!");
    }
}
