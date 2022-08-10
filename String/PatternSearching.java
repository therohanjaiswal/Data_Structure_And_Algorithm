// https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
class Solution {
    // TC: O((n - m + 1) * m), This works for all cases
    public static void patternSearchNaive(String str, String pattern) {
        int n = str.length(), m = pattern.length();
        for (int i = 0; i < n - m + 1; ++i) {
            int j;
            for (j = 0; j < m; ++j)
                if (str.charAt(i + j) != pattern.charAt(j))
                    break;

            if (j == m)
                System.out.println(i);
        }
    }

    // Tc: O((n - m + 1)*m), SC: O(1)
    public static void patternSearchBetter(String str, String pattern) {
        int n = str.length(), m = pattern.length();
        for (int i = 0; i < n - m + 1; ++i) {
            int j;
            for (j = 0; j < m; ++j) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    i = i + j - 1;
                    break;
                }
            }
            if (j == m) {
                System.out.println(i);
                i = i + j - 1;
            }
        }
    }

    public static void main(String[] args) {
        String str = "ABCABCDABCD";
        String pattern = "ABCD";
        patternSearchNaive(str, pattern);
        patternSearchBetter(str, pattern);
    }
}
