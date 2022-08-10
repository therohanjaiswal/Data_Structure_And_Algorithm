
// https://www.geeksforgeeks.org/find-k-closest-numbers-in-an-unsorted-array/
import java.util.*;

class Solution {
    // TC: O(n*k), SC: O(1)
    public static ArrayList<Integer> findKClosestNaive(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];

        // ith iteration finds out ith closest val
        for (int i = 0; i < k; ++i) {
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = 0;
            for (int j = 0; j < n; ++j) {
                if (visited[j] == false && Math.abs(arr[j] - x) < minDiff) {
                    minDiff = Math.abs(arr[j] - x);
                    minDiffIndex = j;
                }
            }
            res.add(arr[minDiffIndex]);
            visited[minDiffIndex] = true;
        }

        return res;
    }

    // TC: O(n), SC: O(k)
    public static List<Integer> findKClosestEfficient(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        if (k > n)
            return list;

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; ++i) {
            maxHeap.add(new Pair(Math.abs(x - arr[i]), arr[i]));
            if (maxHeap.size() > k)
                maxHeap.remove();
        }

        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.remove();
            list.add(p.key);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 1, 5 };
        int k = 4, x = 3;
        System.out.println(findKClosestEfficient(arr, k, x));
    }
}

class Pair implements Comparable<Pair> {
    int diff;
    int key;

    public Pair(int d, int k) {
        diff = d;
        key = k;
    }

    public int compareTo(Pair p) {
        if (p.diff < this.diff)
            return 1;
        else if (p.diff == this.diff) {
            if (p.key < this.key)
                return 1;
            return -1;
        }

        return -1;
    }
}