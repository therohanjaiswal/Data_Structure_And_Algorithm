// https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
class Solution {
    // TC: O(n^2), SC: O(n)
    public static int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int availLenOfRod = 1; availLenOfRod < n + 1; ++availLenOfRod) {
            int maxProfit = 0;
            // price[i = 0] stores price of rod of length 1
            // currLenOfRod = 0 considers price of rod of length = 1
            for (int currLenOfRod = 0; currLenOfRod < n; ++currLenOfRod) {
                // if curr length of rod is less than available length of rod
                if (currLenOfRod < availLenOfRod) {
                    int remainingLen = availLenOfRod - (currLenOfRod + 1);
                    int remainingProfit = dp[remainingLen];
                    int totalProfit = remainingProfit + price[currLenOfRod];

                    if (totalProfit > maxProfit)
                        maxProfit = totalProfit;
                }
            }
            dp[availLenOfRod] = maxProfit;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int N = 8;
        int[] Price = { 1, 5, 8, 9, 10, 17, 17, 20 };

        System.out.println("Maximum Profit: " + cutRod(Price, N));
    }
}