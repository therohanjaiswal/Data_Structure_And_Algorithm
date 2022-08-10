
// https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(1)
    public static void printNByKNaive(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < n; ++i) {
            while (i < arr.length && arr[i] == arr[i - 1]) {
                ++count;
                ++i;
            }
            if (count > n / k)
                System.out.print(arr[i - 1] + " ");
            count = 1;
        }
        System.out.println();
    }

    // TC: O(n), SC: O(n)
    public static void printNByKRfficient(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet())
            if (e.getValue() > n / k)
                System.out.print(e.getKey() + " ");
        System.out.println();
    }

    // TC: O(n*k), SC: O(k), when k is small and n is large.
    // Based on moore's voting algo for finding majority element
    public static void printNByK(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else if (map.size() < k - 1)
                map.put(arr[i], 1);
            else {
                for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                    int c = e.getValue() - 1;
                    if (c == 0)
                        map.remove(e.getKey());
                    else
                        map.put(e.getKey(), c);
                }
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int count = 0;
            for (int i = 0; i < n; ++i)
                if (arr[i] == e.getKey())
                    ++count;

            if (count > n / k)
                System.out.print(e.getKey() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = { 10, 10, 20, 30, 20, 10, 10 };
        int[] arr = { 30, 10, 20, 20, 20, 10, 40, 30, 30 };
        int k = 4;
        printNByKNaive(arr, k);
        printNByKRfficient(arr, k);
        printNByK(arr, k);
    }
}
