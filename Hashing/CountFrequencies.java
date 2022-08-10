
// https://www.geeksforgeeks.org/counting-frequencies-of-array-elements/
import java.util.*;

class Solution {
    // TC: O(n^2) SC: O(1)
    public static void countFrequenciesNaive(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            // checks if arr[i] is seen before
            boolean flag = false;
            for (int j = 0; j < i; ++j) {
                if (arr[j] == arr[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;

            // count frequency of arr[i]
            int freq = 1;
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[i] == arr[j])
                    ++freq;
            System.out.println(arr[i] + " " + freq);
        }
    }

    // TC: O(n), SC: O(1)
    public static void countFrequenciesEfficient(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 20, 30 };
        countFrequenciesNaive(arr);
        countFrequenciesEfficient(arr);
    }
}
