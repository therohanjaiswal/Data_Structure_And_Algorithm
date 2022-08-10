// https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
class Solution {
    static final int CHAR = 256;

    // TC: O(n), SC: O(n)
    public static int search(String txt, String pat) {
        int[] countTxt = new int[CHAR];
        int[] countPat = new int[CHAR];
        int n = txt.length();
        int m = pat.length();

        if (n < m)
            return 0;

        int count = 0;
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
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(txt, pat));
    }
}