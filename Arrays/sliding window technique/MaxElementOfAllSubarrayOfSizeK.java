
// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
import java.util.*;

class Solution {
    // I had thought of using a max heap to take out the max element
    // from every window but that is slow as it will take logn time for each
    // insertion and deletion. So TC will be O(n*logk).
    // But here instead of maxHeap, we use arraydeque in which insertion and
    // deletion operation takes O(1) time. Here the max element element is present
    // in the front of arraydeque or we can say it stores the elements in decreasing
    // order. The new element of current window is inserted from end.
    // TC: O(n), SC: O(n)
    public static List<Integer> maxOfSubarray(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> dque = new ArrayDeque<>();

        for (int i = 0; i < k; ++i) {
            // delete all the elements from front if ith element is greater
            // as for current window this ith element will be maximum
            while (!dque.isEmpty() && arr[i] > arr[dque.peekFirst()])
                dque.removeFirst();
            dque.addLast(i);
        }

        res.add(arr[dque.peekFirst()]);
        for (int i = k; i < arr.length; ++i) {
            if (!dque.isEmpty() && i - k == dque.peekFirst())
                dque.removeFirst();
            while (!dque.isEmpty() && arr[i] > arr[dque.peekFirst()])
                dque.removeFirst();
            dque.add(i);
            res.add(arr[dque.peekFirst()]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        List<Integer> res = maxOfSubarray(arr, k);
        System.out.println(res);
    }
}