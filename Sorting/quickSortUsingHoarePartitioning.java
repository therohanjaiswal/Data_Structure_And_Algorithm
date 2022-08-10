class Solution {
    public static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;
            swap(arr, i, j);
        }
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
            swap(arr, rand, low);
            int partition = hoarePartition(arr, low, high);
            // partition index is passed as partition element
            // not placed at correct position
            quickSort(arr, low, partition);
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
