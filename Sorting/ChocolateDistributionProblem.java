import java.util.Arrays;

public class Solution {
    public static int minDiff(int[] arr, int m) {
        int n = arr.length;
        if (m > n)
            return -1;
        Arrays.sort(arr);
        int result = arr[m - 1] - arr[0];
        for (int i = 1; i < arr.length - m + 1; ++i)
            result = Math.min(result, arr[i + m - 1] - arr[i]);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
        int m = 3;
        System.out.println(minDiff(arr, m));
    }
}
