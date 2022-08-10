// https://www.geeksforgeeks.org/program-to-find-whether-a-given-number-is-power-of-2/
class Solution {
    // TC: O(logn), SC: O(1)
    public static boolean isPowerOfTwoNaive(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }

        return true;
    }

    // Use Brian Kerningam's Algorithm
    // When we do n & (n-1). It makes the nth bit to 0 and
    // all the bits before that are 0 or 1
    // TC: O(1), SC: O(1)
    public static boolean isPowerOfTwoEfficient(int n) {
        if (n == 0)
            return false;

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 98;
        if (isPowerOfTwoNaive(n))
            System.out.println(n + " is power of two.");
        else
            System.out.println(n + " is not a power of two.");
    }
}