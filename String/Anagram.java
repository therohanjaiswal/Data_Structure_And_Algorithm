
// https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
import java.util.*;

class Solution {
    static final int CHAR = 256;

    // TC: O(n), SC: O(n)
    public static boolean areAnagramEfficient(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        int[] count = new int[CHAR];
        Arrays.fill(count, 0);
        for (int i = 0; i < str1.length(); ++i) {
            ++count[str1.charAt(i)];
            --count[str2.charAt(i)];
        }

        for (int i = 0; i < CHAR; ++i)
            if (count[i] != 0)
                return false;
        return true;
    }

    // TC: O(nlogn), SC: O(1)
    public static boolean areAnagramNaive(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        str1 = new String(arr1);

        arr1 = str2.toCharArray();
        Arrays.sort(arr1);
        str2 = new String(arr1);

        if (str1.equals(str2))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String str1 = "geeks", str2 = "keegs";
        if (areAnagramEfficient(str1, str2))
            System.out.println(str1 + " and " + str2 + " are Anagrams.");
        else
            System.out.println(str1 + " and " + str2 + " are not Anagrams.");
    }
}