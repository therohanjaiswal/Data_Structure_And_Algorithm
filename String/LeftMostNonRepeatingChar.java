
// https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
import java.util.Arrays;

public class Solution {
    static final int CHAR = 256;

    // performs one traversal of input string
    // TC: O(n), SC: O(1)
    public static int leftMostNonRepeatingEfficient(String str) {
        int[] count = new int[CHAR];
        Arrays.fill(count, -1);
        for (int i = 0; i < str.length(); ++i) {
            if (count[str.charAt(i)] == -1)
                count[str.charAt(i)] = i;
            else
                count[str.charAt(i)] = -2;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; ++i)
            if (count[i] >= 0)
                res = Math.min(res, count[i]);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // performs two traversal of input string
    // TC: O(n), SC: O(1)
    public static int leftMostNonRepeating(String str) {
        int[] count = new int[CHAR];
        Arrays.fill(count, 0);
        for (int i = 0; i < str.length(); ++i) {
            if (count[str.charAt(i)] == 0)
                ++count[str.charAt(i)];
            else
                --count[str.charAt(i)];
        }

        for (int i = 0; i < str.length(); ++i)
            if (count[str.charAt(i)] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        String str = "abccbd";
        System.out.println(leftMostNonRepeating(str));
    }
}
