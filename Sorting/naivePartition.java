// TC: O(n), SC: O(n)
// Stable but not inplace

class Solution {
    public static int naivePartition(int[] arr, int low, int high, int pivot) {
        int[] temp = new int[high - low + 1];
        int k = 0;

        for (int i = low; i <= high; ++i)
            if (arr[i] < arr[pivot])
                temp[k++] = arr[i];

        for (int i = low; i <= high; ++i)
            if (arr[i] == arr[pivot])
                temp[k++] = arr[i];

        int result = low + k - 1;
        for (int i = low; i <= high; ++i)
            if (arr[i] > arr[pivot])
                temp[k++] = arr[i];

        for (int i = low; i <= high; ++i)
            arr[i] = temp[i - low];

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 8, 3, 7 };
        int pivot = 1; // index
        System.out.println("Before Partition");
        for (int a : arr)
            System.out.print(a + " ");

        int partition = naivePartition(arr, 0, arr.length - 1, pivot);
        System.out.println();
        System.out.println("Partition at " + partition);
        System.out.println("After partition");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
