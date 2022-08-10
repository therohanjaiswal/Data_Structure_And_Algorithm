
// https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
import java.util.*;

class Solution {
    // TC: O(n + klog(n)), SC: O(n)
    public static int[] kLargestElementEfficient(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; ++i)
            maxHeap.add(arr[i]);

        for (int i = 0; i < k; ++i)
            res[i] = maxHeap.poll();

        return res;
    }

    // TC: O(nlogn), SC: O(1)
    public static int[] kLargestElementNaive(int[] arr, int k) {
        int[] res = new int[k];
        int index = 0;

        for (int i = 0; i < k; ++i) {
            for (int j = i; j < arr.length - i - 1; ++j)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            res[index++] = arr[arr.length - i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 787, 1, 123 };
        int k = 2;
        int[] res = kLargestElementNaive(arr, k);
        for (int i = 0; i < res.length; ++i)
            System.out.print(res[i] + " ");

        System.out.println();

        res = kLargestElementEfficient(arr, k);
        for (int i = 0; i < res.length; ++i)
            System.out.print(res[i] + " ");
    }
}