
// https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
import java.util.*;

class SubarrayWithZeroSum {
    // TC: O(n^2), SC: O(1)
    public static boolean findSumNaive(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int sum = 0;
            for (int j = i; j < arr.length; ++j) {
                sum += arr[j];
                if (sum == 0)
                    return true;
            }
        }
        return false;
    }

    // TC: O(n), SC: O(n)
    public static boolean findsumEfficient(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            prefixSum += arr[i];
            if (arr[i] == 0 || set.contains(prefixSum) || prefixSum == 0)
                return true;
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 0, 1, 6 };
        System.out.println(findSumNaive(arr));
        System.out.println(findSumNaive(arr));
    }
}
