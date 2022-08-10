import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(1)
    public static int maxItemsNaive(int[] arr, int sum) {
        int n = arr.length;
        int items = 0;
        Arrays.sort(arr);
        int i = 0;
        while (i < n && arr[i] <= sum) {
            ++items;
            sum -= arr[i];
            i++;
        }

        return items;
    }

    // TC: O(n), SC: O(n)
    public static int maxItemsEfficient(int[] arr, int sum) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i)
            minHeap.add(arr[i]);

        int items = 0;
        while (sum >= 0) {
            if (sum == 0)
                return items;
            int curr = minHeap.poll();
            ++items;
            sum -= curr;
        }

        return items;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        int sum = 10;
        System.out.println(maxItemsNaive(arr, sum));
        System.out.println(maxItemsEfficient(arr, sum));
    }
}