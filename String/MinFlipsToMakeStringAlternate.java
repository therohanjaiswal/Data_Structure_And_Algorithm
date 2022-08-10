// https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
// https://www.geeksforgeeks.org/minimum-number-of-replacements-to-make-the-binary-string-alternating-set-2/

class Solution {
    // TC: O(n), SC: O(1)
    public static int minFlipsToMakeAlternativeNaive(String s) {
        // return minimum of following two
        // 1) flips when alternate string starts with 0
        // 2) flips when alternate string starts with 1
        return Math.min(flipsWithStartChar(s, '0'), flipWithStartChar(s, '1'));
    }

    // returns min flips when alternate string starts with expected char
    public static int flipWithStartChar(String str, char expected) {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++) {
            // if curr char is not expected, increase flip count
            if (str.charAt(i) != expected)
                flipCount++;

            // flip the expected char to next expected character each time
            // if ith = 0 then (i + 1)th should be 1 and vice versa
            expected = flip(expected);
        }
        return flipCount;
    }

    // Utility method to flip a character
    public static char flip(char ch) {
        return (ch == '0') ? '1' : '0';
    }

    // TC: O(n), SC: O(1)
    // Idea: flipsWithStartCharOne = n - flipsWithStartCharOne
    public static int minFlipsToMakeAlternativeEfficient(String s) {
        int n = s.length();

        // Here we are checking flips with start char 0
        int flips = 0;
        for (int i = 0; i < n; i++) {
            // If there is 1 at even index positions, which it should not be.
            // It should be 0 as string starts with 0. So, increase the no of flips
            if (i % 2 == 0 && s.charAt(i) == '1')
                ++flips;

            // If there is 0 at odd index positions, which it should not be.
            // It should be 1 as string starts with 0. So, increase the no of flips.
            if (i % 2 == 1 && s.charAt(i) == '0')
                ++flips;
        }
        return Math.min(flips, n - flips);
    }

    public static void main(String[] args) {
        String s = "1100";
        int res = getMinFlipsToMakeAlternative2(s);
        System.out.println("Min Flips: " + res);
    }
}
