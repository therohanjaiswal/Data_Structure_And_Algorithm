// https://www.youtube.com/watch?v=Zobz9BXpwYE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=5
class Solution {
    // TC: O(n), SC: O(n)
    public static int minMovesClimbingStairs(int[] arr) {
        // int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        // arr[i] = 2 means at index i we can move atmost 2 steps further
        // arr[i] = 0 means at index i we can't move any step further
        int n = arr.length;
        Integer[] dp = new Integer[n + 1];

        dp[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j < dp.length; ++j)
                if (dp[i + j] != null)
                    min = Math.min(dp[i + j], min);

            if (min != Integer.MAX_VALUE)
                dp[i] = 1 + min;
            else
                // means min is not updated coz the next j steps were all null for this i
                // arr[7] = 2 and the next 2 steps are 0 which makes dp[8]= dp[9] = null
                dp[i] = null;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        System.out.println("Minimum cost: " + minMovesClimbingStairs(arr));
    }
}