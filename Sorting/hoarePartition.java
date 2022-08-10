// TC: O(n)
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

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
        System.out.println("Before Partition");
        for (int a : arr)
            System.out.print(a + " ");
        int partition = hoarePartition(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("Partition at " + partition);
        System.out.println("After partition");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
