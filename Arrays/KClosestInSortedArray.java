
// https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(1)
    public static List<Integer> findKClosestElementsSortedArray(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high] - x))
                low++;
            else
                high--;
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = low; i <= high; i++)
            result.add(arr[i]);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4, x = 3;
        System.out.println(findKClosestElementsSortedArray(arr, k, x));
    }
}