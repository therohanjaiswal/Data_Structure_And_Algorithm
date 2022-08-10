// https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13

class Solution {
    // TC: O(n*sum), SC: O(sum)
    public static int coinChangeComb(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; ++i)
            for (int j = coins[i]; j < amount + 1; ++j)
                dp[j] += dp[j - coins[i]];

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5 };
        int amount = 7;
        System.out.println(coinChangeComb(coins, amount));
    }
}