
// https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
import java.util.*;

class Solution {
    // TC:O(n^2), SC:O(1)
    public static boolean isPairNaive(int[] arr, int sum) {
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = sum - arr[i];
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] == diff)
                    return true;
            }
        }
        return false;
    }

    // TC:O(n), SC: O(m), m is no of distinct elements
    public static boolean isPairEfficient(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            int diff = sum - arr[i];
            if (set.contains(diff))
                return true;
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 3, 9 };
        int sum = 13;
        System.out.println(isPairNaive(arr, sum));
        System.out.println(isPairEfficient(arr, sum));
    }
}
