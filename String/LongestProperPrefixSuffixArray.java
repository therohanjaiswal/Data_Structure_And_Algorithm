public class Solution {
    // My implementation
    public static int[] computeLPSArray(String str) {
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int start = 0, maxlength = 0;
        for (int end = 1; end < str.length(); ++end) {
            maxlength = 0;
            for (int x = 1; x <= end; ++x) {
                String pref = str.substring(start, x);
                String suff = str.substring(end - x + 1, end + 1);
                if (pref.equals(suff))
                    maxlength = Math.max(maxlength, pref.length());
            }
            lps[end] = maxlength;
        }
        return lps;
    }

    // TC: O(n)
    public static void fillLPSEfficient(String str, int[] lps) {
        int n = str.length(), len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                ++len;
                lps[i] = len;
                ++i;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    ++i;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

    public static int longPrefSuff(String str, int n) {
        for (int len = n - 1; len > 0; --len) {
            boolean flag = true;
            for (int i = 0; i < len; ++i)
                if (str.charAt(i) != str.charAt(n - len + i))
                    flag = false;
            if (flag == true)
                return len;
        }
        return 0;
    }

    // TC: O(n^3)
    public static void fillLPS(String str, int[] lps) {
        for (int i = 0; i < str.length(); ++i)
            lps[i] = longPrefSuff(str, i + 1);
    }

    public static void main(String[] args) {
        String str = "abbabb";
        int[] lps = computeLPSArray(str);
        for (int i : lps) {
            System.out.print(i + " ");
        }
    }
}
