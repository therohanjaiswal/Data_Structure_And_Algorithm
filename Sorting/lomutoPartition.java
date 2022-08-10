// TC: O(n), SC: O(1)
// Inplace but not Stable
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

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
        System.out.println("Before Partition");
        for (int a : arr)
            System.out.print(a + " ");
        int partition = lomutoPartition(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("Partition at " + partition);
        System.out.println("After partition");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
