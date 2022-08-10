
// https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
import java.util.*;

class Solution {
    public static int countSubArrays(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            prefixSum += arr[i];
            if (prefixSum == sum)
                ++result;

            if (map.containsKey(prefixSum - sum))
                result += map.get(prefixSum - sum);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }

    public static void findSubArrays(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int start = 0, end = -1;
        for (int i = 0; i < arr.length; ++i) {
            prefixSum += arr[i];

            if (prefixSum == sum) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(prefixSum - sum)) {
                start = map.get(prefixSum - sum) + 1;
                end = i;
                break;
            }

            map.put(prefixSum, i);
        }

        if (end == -1)
            System.out.println("Subarray not found.");
        else
            System.out.println("Sum found between indexes " + start + " to " + end);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, -2, -20, 10 };
        int sum = -10;
        findSubArrays(arr, sum);
        System.out.println(countSubArrays(arr, sum));
    }
}