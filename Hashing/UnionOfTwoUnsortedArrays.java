
// https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
import java.util.*;

class Solution {
    // TC: O(n + m), SC: O(n + m)
    public static int findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; ++i)
            set.add(arr1[i]);

        for (int i = 0; i < arr2.length; ++i)
            set.add(arr2[i]);
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 10, 30, 20 };
        int[] arr2 = { 20, 10, 10, 40 };
        int result = findUnion(arr1, arr2);
        System.out.println("Number of unique elements in union: " + result);
        result = findUnion(arr1, arr2);
        System.out.println("Number of unique elements in union: " + result);
    }
}
