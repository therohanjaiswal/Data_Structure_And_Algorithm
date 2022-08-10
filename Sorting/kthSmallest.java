// https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
// TC: O(n), SC: O(1) 

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

    public static int kthSmallest(int[] arr, int low, int high, int k) {
        // here low == high as we are searching for an element, so one single element
        // can be required element
        if (low <= high) {
            int p = lomutoPartition(arr, low, high);
            if (k == p + 1)
                return arr[p];
            else if (k > p + 1)
                return kthSmallest(arr, p + 1, high, k);
            else
                return kthSmallest(arr, low, p - 1, k);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 3, 20, 15 };
        int k = 3;
        System.out.print(k + "th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
    }
}
