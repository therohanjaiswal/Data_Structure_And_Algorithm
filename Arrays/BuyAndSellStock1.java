// https://www.geeksforgeeks.org/best-time-to-buy-and-sell-stock/
class Solution {
    // In this problem, we can buy and sell stocks only once. Also,
    // buy the stock before selling it.
    // TC: O(n), SC: O(1)
    public static int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; ++i) {
            minSoFar = Math.min(minSoFar, prices[i]);
            if (prices[i] > minSoFar)
                profit = Math.max(profit, prices[i] - minSoFar);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}