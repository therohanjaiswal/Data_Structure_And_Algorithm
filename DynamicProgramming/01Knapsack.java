// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
class Solution {
    // TC: O(N * W), SC: O(N * W)
    public static int knapSack(int W, int wt[], int val[], int n) { 
        int[][] dp = new int[n+1][W+1]; 
        for(int i = 0; i < n + 1; ++i) 
            for(int j = 0; j < W + 1; ++j) 
                if(i == 0 || j == 0)
                    dp[i][j] = 0;    
            
        
        for(int i = 1; i < n + 1; ++i) {
            for(int j = 1; j < W + 1; ++j) {
                if(wt[i - 1] <= j)
                    dp[i][j] = (int) Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else 
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    } 

    public static void main(String[] args) {
        int W = 3, N = 3;
        int[] values = {1,2,3};
        int[] weight = {4,5,1};
        int res = knapSack(W, weight, values, N);
        System.out.println(res);
    }
}