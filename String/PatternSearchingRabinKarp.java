// https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/

class Solution {

    // d is the number of characters in the input alphabet
    public final static int d = 256;

    // TC: AC: O(n) WC: O((n - m + 1) * m)
    public static void patternSearchRabinKarp(String text, String pattern, int q) {
        int n = text.length(), m = pattern.length();
        int h = 1;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text

        for (i = 0; i < m - 1; ++i)
            h = (h * d) % q;

        for (i = 0; i < m; ++i) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (i = 0; i < n - m + 1; ++i) {
            if (p == t) {
                for (j = 0; j < m; ++j) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == m) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0)
                    t += q;
            }
        }
    }

    public static void main(String[] args) {
        String text = "abdabcbabc";
        String pattern = "abc";
        // A prime number
        int q = 101;

        searchPattern(text, pattern, q);
    }
}
