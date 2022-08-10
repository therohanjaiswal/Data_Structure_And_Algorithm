
// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
import java.util.*;

class Solution {
    // TC: O(n*amount), SC: O(amount)
    public static int coinChangeMinimum(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int amt = 1; amt < amount + 1; ++amt) {
            for (int coin : coins) {
                if (coin <= amt) {
                    int remainAmt = amt - coin;
                    if (dp[remainAmt] != Integer.MAX_VALUE)
                        dp[amt] = Math.min(1 + dp[remainAmt], dp[amt]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 6 };
        int amount = 10;
        System.out.println(coinChangeMinimum(coins, amount));
    }
}