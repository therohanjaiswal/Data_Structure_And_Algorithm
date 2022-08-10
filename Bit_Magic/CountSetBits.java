// https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
class Solution {
    // TC: O(logn), SC: O(1)
    public static int setBitsNaive(int n) {
        if (n == 0)
            return 0;

        return (n & 1) + setBitsNaive(n >> 1);
    }

    // Brian Kerningam's Algorithm
    // When we do n & (n-1). It makes the nth bit to 0 and
    // all the bits before that are 0 or 1
    // TC: O(no of set bits), SC: O(1)
    public static int setBitsBetter(int n) {
        int res = 0;

        while (n > 0) {
            n = n & (n - 1);
            ++res;
        }

        return res;
    }

    // LookUp table method
    // TC: O(1), SC: O(1)
    public static int setBitsEfficient(int n) {
        int[] table = initialize();
        int res = table[n & 0xff];
        n = n >> 8;
        res += table[n & 0xff];
        n = n >> 8;
        res += table[n & 0xff];
        n = n >> 8;
        res += table[n & 0xff];
        return res;
    }

    public static int[] initialize() {
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 1; i < 256; ++i)
            table[i] = (i & 1) + table[i / 2];
        return table;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Set bits: " + setBitsNaive(n));
        System.out.println("Set bits: " + setBitsBetter(n));
        System.out.println("Set bits: " + setBitsEfficient(n));
    }
}