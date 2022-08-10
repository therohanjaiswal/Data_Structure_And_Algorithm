// https://www.youtube.com/watch?v=qmTtAbOTqcg&t=1138s
class Solution {
    // TC: O(n^3), SC: O(n^2)
    public static int palindromicPartitionNaive(String str) {
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int gap = 0; gap < n; ++gap) {
            for (int i = 0, j = i + gap; j < n; ++j, ++i) {
                if (gap == 0)
                    isPalindrome[i][j] = true;
                else if (gap == 1) {
                    isPalindrome[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    if (str.charAt(i) == str.charAt(j) && isPalindrome[i + 1][j - 1])
                        isPalindrome[i][j] = true;
                    else
                        isPalindrome[i][j] = false;
                }
            }
        }

        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; ++gap) {
            for (int i = 0, j = gap + i; j < n; ++i, ++j) {
                if (gap == 0)
                    dp[i][j] = 0;
                else if (gap == 1) {
                    if (isPalindrome[i][j])
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1;
                } else {
                    if (isPalindrome[i][j])
                        dp[i][j] = 0;
                    else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; ++k) {
                            // partition between index k and k+1
                            // left part - dp[i][k], right part = dp[k+1][j]
                            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = 1 + min;
                    }
                }

            }
        }

        return dp[0][n - 1];
    }

    // TC: O(n^2), SC: O(n^2)
    public static int palindromicPartitionEfficient(String str) {
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int gap = 0; gap < n; ++gap) {
            for (int i = 0, j = i + gap; j < n; ++j, ++i) {
                if (gap == 0)
                    isPalindrome[i][j] = true;
                else if (gap == 1) {
                    isPalindrome[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    if (str.charAt(i) == str.charAt(j) && isPalindrome[i + 1][j - 1])
                        isPalindrome[i][j] = true;
                    else
                        isPalindrome[i][j] = false;
                }
            }
        }

        int[] dp = new int[n];
        // dp[i] = min cut req for string[0, i]
        dp[0] = 0;
        for (int j = 1; j < n; ++j) {
            if (isPalindrome[0][j]) // if string[0, j] is palindrome
                dp[j] = 0;
            else { // if suffix are palindrome, check for every suffix
                int min = Integer.MAX_VALUE;
                for (int i = j; i > 0; --i) {
                    if (isPalindrome[i][j]) {
                        min = Math.min(min, dp[i - 1]);
                    }
                }
                dp[j] = 1 + min;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        String str = "abbac";
        System.out.println("Minimum number of cut required:" + palindromicPartitionNaive(str));
        System.out.println("Minimum number of cut required: " + palindromicPartitionEfficient(str));
    }
}