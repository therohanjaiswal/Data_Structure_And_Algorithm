// https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/

public class Solution {
    // TC: O(m+n), SC: O(1)
    public static boolean isSubsequenceIterative(String str, String target) {
        if (target.length() == 0) // empty string is always a subsequence
            return true;

        if (str.length() == 0)
            return false;

        int i = 0, j = 0;
        while (i < str.length() && j < target.length()) {
            if (str.charAt(i) == target.charAt(j)) {
                ++i;
                ++j;
            } else
                ++i;

            if (j == target.length())
                return true;
        }
        return false;
    }

    // TC: O(m + n), SC: O(call stack)
    public static boolean isSubsequenceRecursive(String str, String target, int i, int j) {
        if (target.length() == 0)
            return true;

        if (j == target.length())
            return true;
        if (str.charAt(i) == target.charAt(j))
            return isSubsequenceRecursive(str, target, ++i, ++j);
        return isSubsequenceRecursive(str, target, ++i, j);
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String target = "gksfs";
        if (isSubsequenceIterative(str, target))
            System.out.println(target + " is a subsequence");
        else
            System.out.println(target + " is not a subsequence");

        if (isSubsequenceRec(str, target, 0, 0))
            System.out.println(target + " is a subsequence");
        else
            System.out.println(target + " is not a subsequence");
    }
}
