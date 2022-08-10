// https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

import java.util.Arrays;

public class Solution {
    static final int CHAR = 256;

    // TC: O((n - m + 1) * m), SC: O(1)
    public static boolean anagramSearchNaive(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i < n - m + 1; ++i)
            if (areAnagram(txt, pat, i))
                return true;

        return false;
    }

    public static boolean areAnagram(String txt, String pat, int i) {
        int[] count = new int[CHAR];
        Arrays.fill(count, 0);
        for (int j = 0; j < pat.length(); ++j) {
            ++count[pat.charAt(j)];
            --count[txt.charAt(i + j)];
        }

        for (int j = 0; j < CHAR; ++j)
            if (count[j] != 0)
                return false;
        return true;
    }

    // TC: O(m + (n - m) * CHAR) = O(n * CHAR)
    public static int anagramSearchEfficient(String txt, String pat) {
        int count = 0;
        int[] countTxt = new int[CHAR];
        int[] countPat = new int[CHAR];
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i < m; ++i) {
            ++countTxt[txt.charAt(i)];
            ++countPat[pat.charAt(i)];
        }

        if (areSame(countTxt, countPat))
            ++count;

        for (int i = m; i < n; ++i) {
            ++countTxt[txt.charAt(i)];
            --countTxt[txt.charAt(i - m)];
            if (areSame(countTxt, countPat))
                ++count;
        }

        return count;
    }

    public static boolean areSame(int[] countTxt, int[] countPat) {
        for (int i = 0; i < CHAR; ++i)
            if (countPat[i] != countTxt[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "keegs";
        boolean present = anagramSearchNaive(txt, pat);
        System.out.println(present);
        int count = anagramSearchEfficient(txt, pat);
        System.out.println(count);
    }
}
