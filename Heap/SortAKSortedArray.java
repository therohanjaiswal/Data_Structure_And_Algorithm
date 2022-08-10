
// https://www.geeksforgeeks.org/nearly-sorted-algorithm/
import java.util.*;

class Solution {

    // Using insertion sort.
    // TC: O(nk), inner loop move k times, SC: O(1)
    public static void kSortNaive(int[] arr, int k) {
        int i, key, j;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && A[j] > key) {
                arr[j + 1] = A[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // TC: O(k + (n-k)logk) = O(nlogk), SC: O(k)
    public static void kSortBetter(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= k; ++i)
            minHeap.add(arr[i]);

        int index = 0;
        for (int i = k + 1; i < arr.length; ++i) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        while (!minHeap.isEmpty())
            arr[index++] = minHeap.poll();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;
        System.out.print("Array before sorting: ");
        for (int i : arr)
            System.out.print(i + " ");
        kSortBetter(arr, k);
        System.out.println();
        System.out.print("Array after sorting: ");
        for (int i : arr)
            System.out.print(i + " ");
    }
}
