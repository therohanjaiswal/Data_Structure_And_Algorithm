// https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3
class Solution {

    // We have to count the number of paths from 0 to n
    // arr[n] denotes the number of steps we can take backwards i.e.,
    // arr[3] = 2 means from 3, we can go upto 2 steps backwards which is upto
    // either 2 or 1
    // TC: O(n), SC: O(n)
    public static int countPaths(int n, int[] arr) {
        int[] dp = new int[n + 1];
        dp[n] = 1; // number of paths from n to n is 1;

        for (int i = n - 1; i >= 0; --i) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; ++j) {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int N = 10;
        int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
        System.out.println("Total paths count: " + countPaths(N, arr));
    }
}