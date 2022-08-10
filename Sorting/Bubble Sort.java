// https://www.geeksforgeeks.org/bubble-sort/
// TC: O(n^2)
// Stable and Inplace Sorting Algorithm

class Solution {
    public static void bubbleSort(int[] arr, int n) {
        int swap = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ++swap;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(swap);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 20, 25, 10, 50 };
        System.out.print("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");

        System.out.println();
        bubbleSort(arr, arr.length);

        System.out.print("Sorted Array: ");
        for (int a : arr)
            System.out.print(a + " ");
    }

}
