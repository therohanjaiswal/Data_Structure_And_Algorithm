
// https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3 };
        int[] res = frequencySort(arr);
        for (int i : res)
            System.out.print(i + " ");
    }

    // TC: O(n), SC: O(n)
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>();
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            maxHeap.add(new Pair(e.getKey(), e.getValue()));

        int[] res = new int[nums.length];
        int i = 0;
        while (maxHeap.size() > 0) {
            Pair p = maxHeap.remove();
            int f = p.freq;
            int e = p.element;
            int end = i + f;
            for (int start = i; start < end; ++start)
                res[i++] = e;
        }

        return res;
    }
}

class Pair implements Comparable<Pair> {
    int element;
    int freq;

    public Pair(int e, int f) {
        element = e;
        freq = f;
    }

    public int compareTo(Pair p) {
        if (this.freq < p.freq)
            return -1;
        else if (this.freq == p.freq) {
            if (this.element < p.element)
                return 1;
            return -1;
        }

        return 1;
    }
}