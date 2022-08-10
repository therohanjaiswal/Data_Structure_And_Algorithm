// https://www.geeksforgeeks.org/insertion-sort/
// TC: BC: O(n), WC: O(n^2)
// Stable and Inplace Sorting Algorithm

class Solution {
    public static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] >= temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.print("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");

        System.out.println();
        insertionSort(arr, arr.length);

        System.out.print("Sorted Array: ");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
