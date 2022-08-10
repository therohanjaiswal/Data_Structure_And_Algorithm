// https://www.geeksforgeeks.org/check-whether-k-th-bit-set-not/
class Solution {
    // Position of LSB is 0th bit
    // TC: O(1) SC: O(1)
    public static boolean isKthBitSetLeftShift(int n, int k) {
        if ((n & (1 << k)) != 0)
            return true;
        else
            return false;
    }

    // TC: O(1) SC: O(1)
    public static boolean isKthBitSetRightShift(int n, int k) {
        if (((n >> k) & 1) == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int n = 5, k = 3;
        if (isKthBitSetLeftShift(n, k))
            System.out.println("kth bit is set.");
        else
            System.out.println("kth bit is not set.");
    }
}