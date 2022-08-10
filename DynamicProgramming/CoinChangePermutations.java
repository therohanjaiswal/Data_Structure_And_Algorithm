// https://www.youtube.com/watch?v=yc0LunmJA1A&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=14

class Solution {
    // TC: O(n*amount), SC: O(amount)
    public static int coinChangePermut(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int amt = 1; amt < amount + 1; ++amt) {
            for (int coin : coins) {
                if (coin <= amt) {
                    int remainAmt = amt - coin;
                    dp[amt] += dp[remainAmt];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5 };
        int amount = 7;
        System.out.println(coinChangePermut(coins, amount));
    }
}