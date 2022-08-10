// https://www.geeksforgeeks.org/delete-an-element-from-array-using-two-traversals-and-one-traversal/
class Solution {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 12, 5, 6 };
        int key = 8;
        System.out.println("New Array size: " + delete(arr, key));
    }

    // WAP to delete an element from an array and return the size of new array.
    // If element is not present return original size
    // For multiple occurence delete the first occurence
    // TC: O(n), Best Case: delete at end : O(1), SC: O(1)
    public static int delete(int[] arr, int k) {
        int n = arr.length;
        if (n == 0)
            return -1;

        // delete at end
        if (arr[n - 1] == k)
            return n - 1;

        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                break;
        }

        if (i == n)
            return n;

        for (int j = i; j < n - 1; j++)
            arr[j] = arr[j + 1];

        return n - 1;
    }
}
