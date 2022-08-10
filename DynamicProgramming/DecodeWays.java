// https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
class Solution {
    // TC: O(n), SC: O(n)
    public static int countWays(String str) {
        int n = str.length();
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        if (str.charAt(0) == '0')
            return 0;

        for (int i = 2; i < n + 1; ++i) {
            count[i] = 0;

            if (str.charAt(i - 1) > '0')
                count[i] = count[i - 1];

            if (str.charAt(i - 2) == '1' || (str.charAt(i - 2) == '2' && str.charAt(i - 1) < '7'))
                count[i] += count[i - 2];
        }

        return count[n];
    }

    public static void main(String[] args) {
        String str = "1234";
        System.out.println("Number of ways: " + countWays(str));
    }
}