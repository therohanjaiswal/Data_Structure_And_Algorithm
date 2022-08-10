// https://www.geeksforgeeks.org/merge-sort/
// TC : O((n+m)log(n+m))
// Stable but not inplace sorting algorithm

class Solution {
    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] aux = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                aux[k++] = arr[i++];
            else if (arr[i] >= arr[j])
                aux[k++] = arr[j++];
        }

        while (i <= mid)
            aux[k++] = arr[i++];

        while (j <= high)
            aux[k++] = arr[j++];

        k = 0;
        for (int l = low; l <= high; l++)
            arr[l] = aux[k++];
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (high <= low)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.print("Original Array: ");
        for (int a : arr)
            System.out.print(a + " ");

        System.out.println();
        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
