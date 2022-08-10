// https://www.geeksforgeeks.org/quick-sort/
// TC: Avg Case: O(nlogn), WC: O(n^2), SC: O(1)
// Inplace but not stable

class Solution {
    public static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot is always the last element
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // low == high not used as one element is already sorted.
            // to handle worst case i.e., when array is already sorted
            int rand = (int) ((Math.random() * (high - low)) + low);
            swap(arr, rand, high);
            int partition = lomutoPartition(arr, low, high);
            // partition index is not passed as partition element
            // already place at correct position
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 7, 9, 3, 10, 5 };
        System.out.println("Before Sorting: ");
        for (int a : arr)
            System.out.print(a + " ");
        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("After Sorting: ");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
