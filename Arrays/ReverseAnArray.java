// https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/

class Solution {
    // TC: O(n), SC: O(1)
    public static void reverseRecursive(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        reverseRecursive(arr, low + 1, high - 1);
    }

    // TC: O(n), SC: O(1)
    public static void reverseIterative(int[] arr, int low, int high) {
        int temp;
        while (low < high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 1, 6, 44, 1 };
        System.out.print("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");
        reverseIterative(arr, 0, arr.length - 1);
        reverseRecursive(arr, 0, arr.length - 1);
        System.out.print("\nReverse Array: ");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
