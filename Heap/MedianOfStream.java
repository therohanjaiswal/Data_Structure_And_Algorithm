
// https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
import java.util.*;

class Solution {

    // TC: O(nlogn), SC: O(n)
    public static void printMedianEfficient(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(arr[0]);
        System.out.println("Median after reading 1 element is " + maxHeap.peek());

        for (int i = 1; i < arr.length; ++i) {
            int median = -1;
            int x = arr[i];

            if (maxHeap.size() > minHeap.size()) {
                if (maxHeap.peek() > x) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                } else {
                    minHeap.add(x);
                }
                // median is avg of two as both has equal elements now ie.,
                // total even no of elements
                median = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                if (x < maxHeap.peek())
                    maxHeap.add(x);
                else {
                    minHeap.add(x);
                    maxHeap.add(minHeap.remove());
                }
                // median is max of maxHeap as there are total odd
                // no of elements
                median = maxHeap.peek();
            }
            System.out.println("Median after reading " + i + " elements is " + median);
        }
    }

    // TC: O(n ^ 2), SC: O(1)
    public static void printMedianNaive(int arr[]) {
        int n = arr.length;
        int i, j, pos, num;
        int count = 1;

        System.out.println("Median after reading 1 element is " + arr[0]);

        for (i = 1; i < n; i++) {
            float median;
            j = i - 1;
            num = arr[i];

            // find position to insert current element in sorted part of array
            pos = binarySearch(arr, num, 0, j);
            // move elements to right to create space to insert the current element
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = num;

            // increment count of sorted elements in array
            count++;

            if (count % 2 != 0)
                median = arr[count / 2];
            else
                median = (arr[(count / 2) - 1] + arr[count / 2]) / 2;

            System.out.println("Median after reading " + (i + 1) + " elements is " + median);
        }
    }

    public static int binarySearch(int[] arr, int item, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == item)
                return mid + 1;
            else if (arr[mid] > item)
                return binarySearch(arr, item, low, mid - 1);
            else
                return binarySearch(arr, item, mid + 1, high);
        }
        return high + 1;
    }

    public static void main(String[] args) {
        int arr1[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        printMedianNaive(arr1);
        System.out.println("------------------------------------------------");
        int arr2[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        printMedianEfficient(arr2);
    }
}