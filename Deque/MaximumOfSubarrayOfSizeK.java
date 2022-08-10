
// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(k)
    public static void printMaxEfficient(int arr[], int n, int k) {
        // to store elemets in decreasing order
        Deque<Integer> d = new LinkedList<>();

        // all the deque operation takes O(1) time
        for (int i = 0; i < k; ++i) {
            while (!d.isEmpty() && arr[i] > arr[d.peekLast()])
                d.removeLast();
            d.addLast(i);
        }

        System.out.print(arr[d.peekFirst()] + " ");

        for (int i = k; i < arr.length; ++i) {
            if (!d.isEmpty() && i - k == d.peekFirst())
                d.removeFirst();

            while (!d.isEmpty() && arr[i] > arr[d.peekLast()])
                d.removeLast();
            d.addLast(i);
            System.out.print(arr[d.peekFirst()] + " ");
        }
    }

    // TC: O(n*k), SC: O(1)
    public static void printMaxNaive(int[] arr, int n, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; ++i) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; ++j)
                max = Math.max(max, arr[j]);
            System.out.print(max + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        printMaxNaive(arr, arr.length, k);
        System.out.println();
        printMaxEfficient(arr, arr.length, k);
    }
}
