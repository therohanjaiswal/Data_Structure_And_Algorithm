
// https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
import java.util.*;

class Solution {
    // TC: O(n*k^2), SC: O(1)
    public static ArrayList<Integer> countDistinctNaive(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length - k + 1; ++i) {
            int countDistinct = 0;
            // checks each window of size k
            for (int j = 0; j < k; ++j) {
                boolean flag = false;
                // checks if arr[i + j] has occured before or not
                for (int p = 0; p < j; ++p) {
                    if (arr[i + j] == arr[i + p]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    ++countDistinct;
            }
            result.add(countDistinct);
        }

        return result;
    }

    // TC: O(n), SC: O(n)
    public static ArrayList<Integer> countDistinctEfficient(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; ++i)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        result.add(map.size());

        for (int i = k; i < arr.length; ++i) {
            if (map.containsKey(arr[i - k])) {
                int c = map.get(arr[i - k]) - 1;
                if (c == 0)
                    map.remove(arr[i - k]);
                else
                    map.put(arr[i - k], c);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;
        System.out.println(countDistinctNaive(arr, k));
        System.out.println(countDistinctEfficient(arr, k));
    }
}
