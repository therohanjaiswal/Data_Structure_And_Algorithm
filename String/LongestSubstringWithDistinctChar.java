
// https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
import java.util.Arrays;

public class Solution {
    static final int CHAR = 256;

    // TC: O(n^3), SC: O(n)
    public static int longSubstrDistCharsNaive(String str) {
        int maxLen = 1;
        for (int i = 0; i < str.length(); ++i) {
            for (int j = i + 1; j < str.length(); ++j) {
                if (isDistinct(str, i, j))
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static boolean isDistinct(String str, int i, int j) {
        boolean[] vis = new boolean[CHAR];
        Arrays.fill(vis, false);
        for (int k = i; k <= j; ++k) {
            if (vis[str.charAt(k)] == true)
                return false;
            vis[str.charAt(k)] = true;
        }
        return true;
    }

    // TC: O(n^2), SC: O(n)
    public static int longSubstrDistCharsBetter(String str) {
        int maxLen = 0;
        boolean[] vis = new boolean[CHAR];
        for (int i = 0; i < str.length(); ++i) {
            Arrays.fill(vis, false);
            for (int j = i; j < str.length(); ++j) {
                if (vis[str.charAt(j)] == true)
                    break;
                vis[str.charAt(j)] = true;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // TC: O(n), SC: O(1)
    public static int longSubstrDistCharsEfficient(String str) {
        int result = 0;
        int[] lastIndex = new int[CHAR];
        Arrays.fill(lastIndex, -1);
        int start = 0, end;
        for (end = 0; end < str.length(); ++end) {
            if (lastIndex[str.charAt(end)] != -1) {
                result = Math.max(result, end - start);
                start = Math.max(start, lastIndex[str.charAt(end)] + 1);
            }
            lastIndex[str.charAt(end)] = end;
        }
        // if all the characters are unique, then start = 0 and end = n
        // so the inside if condition is not satisfied to update the len
        // Hence, updating it here.
        result = Math.max(result, end - start);
        return result;
    }

    public static void main(String[] args) {
        String str = "abcdabc";
        System.out.println("Substring length: " + longSubstrDistCharsNaive(str));
        System.out.println("Substring length: " + longSubstrDistCharsBetter(str));
        System.out.println("Substring length: " + longSubstrDistCharsEfficient(str));
    }
}
