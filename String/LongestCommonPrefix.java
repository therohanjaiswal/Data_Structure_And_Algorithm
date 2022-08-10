class Solution {
    // TC: O(N * M), N = number of strings, M = len(shortest string), SC: O(1)
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < n; ++i)
            prefix = commonPrefix(prefix, strs[i]);

        return prefix;

    }

    String commonPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, m = str1.length(), n = str2.length();

        while (i < m && j < n) {
            if (str1.charAt(i) != str2.charAt(j))
                break;
            sb.append(str1.charAt(i));
            ++i;
            ++j;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(strs));
    }
}