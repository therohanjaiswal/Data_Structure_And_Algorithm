import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static int findMinDiff(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return Integer.MAX_VALUE;
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for (int i = 1; i < n - 1; ++i)
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 3, 20, 12 };
        System.out.println(findMinDiff(arr));
    }
}
