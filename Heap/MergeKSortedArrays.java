
// https://www.geeksforgeeks.org/merge-k-sorted-arrays/
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] arr = { { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 } };

        int[] result = mergeKSortedArrayNaive(arr, arr.length);

        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
        ArrayList<Integer> res = mergeKSortedArraysEfficient(arr, arr.length);
        System.out.println(res);
    }

    // TC: O(nkLog(nk)), SC: O(1)
    public static int[] mergeKSortedArrayNaive(int[][] arr, int k) {
        int[] res = new int[k * arr[0].length];
        int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                res[index++] = arr[i][j];
            }
        }

        Arrays.sort(res);
        return res;
    }

    // TC: O(nkLog(k)), SC: O(k)
    public static ArrayList<Integer> mergeKSortedArraysEfficient(int[][] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; ++i)
            minHeap.add(new Triplet(arr[i][0], i, 0));

        while (!minHeap.isEmpty()) {
            Triplet curr = minHeap.remove();
            res.add(curr.val);
            int aP = curr.arrayPos;
            int vP = curr.valPos;
            if (vP + 1 < arr[aP].length)
                minHeap.add(new Triplet(arr[aP][vP + 1], aP, vP + 1));
        }
        return res;
    }
}

class Triplet implements Comparable<Triplet> {
    int val, arrayPos, valPos;

    Triplet(int v, int aP, int vP) {
        val = v;
        arrayPos = aP;
        valPos = vP;
    }

    public int compareTo(Triplet t) {
        if (val <= t.val)
            return -1;
        return 1;
    }
}