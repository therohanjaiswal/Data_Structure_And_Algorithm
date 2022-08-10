// https://www.geeksforgeeks.org/count-possible-ways-to-construct-buildings/
class Solution {
    // TC: O(n), SC: O(1)
    public static int totalWaysNaive(int N) {
        int[][] dp = new int[2][N + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < N + 1; ++i) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
        }

        long sum = dp[0][N] + dp[1][N];
        long ans = sum * sum;

        return (int) ans;
    }

    // TC: O(n), SC: O(1)
    public static int totalWaysEfficient(int N) {
        int oldBuilding = 1;
        int oldSpace = 1;

        for (int i = 2; i < N + 1; ++i) {
            int newBuildings = oldSpace;
            int newSpace = oldSpace + oldBuilding;

            oldSpace = newSpace;
            oldBuilding = newBuildings;
        }

        int total = oldBuilding + oldSpace;
        total = total * total;

        return total;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalWaysNaive(n));
        System.out.println(totalWaysEfficient(n));
    }
}