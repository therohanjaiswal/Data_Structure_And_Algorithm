// https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
class Solution {
    // TC: O(n^2), SC: O(n)
    public static int uniqueBsts(int N) {
        // rec(n) = rec(0)*rec(n-1) + rec(1)*rec(n-2) + ... + rec(n-1)*rec(0)
        long[] dp = new long[N + 1];
        int mod = 1000000007;
        dp[0] = 1;

        for (int i = 1; i < N + 1; ++i) {
            long bsts = 0;
            for (int low = 0, high = i - 1; low < i; ++low, --high) {
                bsts += (dp[low] % mod * dp[high] % mod) % mod;
            }
            dp[i] = bsts % mod;
        }

        return (int) dp[N];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Unique BSTs: " + uniqueBsts(n));
    }
}