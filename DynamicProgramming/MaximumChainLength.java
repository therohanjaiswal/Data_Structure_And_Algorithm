
// https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // TC: O(n^2), SC: O(n)
    public static int maxChainLength(Pair[] arr, int n) {
        Arrays.sort(arr, new CompareByFirst());
        int[] dp = new int[n];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < n; ++i) {
            int max = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j].y < arr[i].x) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Pair arr[] = new Pair[] {
                new Pair(5, 24),
                new Pair(15, 25),
                new Pair(27, 40),
                new Pair(50, 60) };
        System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length));
    }
}

class CompareByFirst implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.x - b.x;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}