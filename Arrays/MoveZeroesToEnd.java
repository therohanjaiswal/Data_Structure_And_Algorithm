// https://www.geeksforgeeks.org/move-zeroes-end-array/

class Solution {
    // Relative order of non zero elements should be same
    // TC: O(n), SC: O(1)
    public static void rearrangeEfficient(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[++j] = arr[i];
            }
        }
        while (++j < arr.length)
            arr[j] = 0;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0, 0, 0 };
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        rearrange(arr);
        System.out.print("\nResultant Array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}