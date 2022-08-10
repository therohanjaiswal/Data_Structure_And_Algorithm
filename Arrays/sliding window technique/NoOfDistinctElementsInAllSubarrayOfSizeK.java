
// https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(n)
    public static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++)
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        result.add(map.size());

        for (int i = k; i < n; i++) {
            if (map.get(A[i - k]) == 1)
                map.remove(A[i - k]);
            else
                map.put(A[i - k], map.get(A[i - k]) - 1);

            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        int n = arr.length;
        int k = 4;
        ArrayList<Integer> result = countDistinct(arr, n, k);
        for (Integer integer : result)
            System.out.println(integer);
    }
}
