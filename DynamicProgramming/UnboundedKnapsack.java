// https://www.youtube.com/watch?v=jgps7MXtKRQ

class Solution {
    // TC: O(N*W), SC: O(W)
    public static int unboundedknapSack(int N, int W, int val[], int wt[]) {
        int[] dp = new int[W + 1];
        dp[0] = 0;
        for (int bagCap = 1; bagCap < W + 1; ++bagCap) {
            int max = 0;
            for (int i = 0; i < N; ++i) {
                if (wt[i] <= bagCap) {
                    int remainingBagCap = bagCap - wt[i];
                    int remainingBagVal = dp[remainingBagCap];
                    int totalBagVal = remainingBagVal + val[i];
                    if (totalBagVal > max)
                        max = totalBagVal;
                }
            }
            dp[bagCap] = max;
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int N = 2, W = 3;
        int[] val = { 1, 1 };
        int[] wt = { 2, 1 };

        System.out.println("Maximum Profit: " + unboundedknapSack(N, W, val, wt));
    }
}