// https://www.geeksforgeeks.org/array-rotation/

class Solution {
    // TC: O(n), SC: O(1)
    public static void leftRotateByD(int[] arr, int d) {
        int n = arr.length;
        if (d > n)
            d = d % n;
        if (d < 0)
            d = d + n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int low, int high) {
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
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int d = 3;
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        leftRotateByD(arr, d);
        System.out.print("\nResultant Array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
