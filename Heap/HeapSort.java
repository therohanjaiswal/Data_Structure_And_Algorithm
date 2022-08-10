// https://www.geeksforgeeks.org/heap-sort/
class Solution {
    public static void maxHeapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (i != largest) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes a random array and converts it into max heap
    public static void buildHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; --i)
            maxHeapify(arr, n, i);
    }

    // TC: O(nlogn), SC: O(1)
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // build heap
        buildHeap(arr, n);

        // select max from top and put it in the end
        for (int i = n - 1; i > 0; --i) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 20, 2, 4, 8 };
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();

        heapSort(arr);

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}
