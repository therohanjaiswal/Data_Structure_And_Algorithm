// https://www.geeksforgeeks.org/selection-sort/
// TC: O(n^2)
// Unstable and Inplace Sorting Algorithm

class Solution {
    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.print("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");

        System.out.println();
        selectionSort(arr, arr.length);

        System.out.print("Sorted Array: ");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
