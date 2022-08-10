
// https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(n^2)
    public String longestPalindromeBetter(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";

        for (int gap = 0; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                // initialization
                if (gap == 0) {
                    dp[i][j] = true;
                }
                // initialization
                else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                // s[i,j] is palindrome if s[i] == s[j] && s[i+1, j-1] is palindrome
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                if (dp[i][j])
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }

    // TC: O(n^2), SC: O(1)
    public String longestPalindromeEfficient(String s) {
        int n = s.length();
        int maxLen = 0;
        String res = "", temp;
        int left, right;

        for (int i = 0; i < n; ++i) {
            // expanding odd length palindrome
            left = i;
            right = i;
            temp = expand(s, left, right);
            if (temp.length() > res.length())
                res = temp;

            // expanding even length palindrome
            left = i - 1;
            right = i;
            temp = expand(s, left, right);
            if (temp.length() > res.length())
                res = temp;
        }

        return res;
    }

    public String expand(String s, int left, int right) {
        String str = "";

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            str = s.substring(left, right + 1);
            --left;
            ++right;
        }

        return str;
    }

    public static void main(String[] args) {
        String str = "babad";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindromeBetter(str));
        System.out.println(sol.longestPalindromeEfficient(str));
    }
}