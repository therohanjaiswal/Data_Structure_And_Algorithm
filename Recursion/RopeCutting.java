class Solution {
    public static void main(String[] args) {
        int n = 9, a = 2, b = 2, c = 2;
        System.out.println(getMaxPieces(n, a, b, c));
    }

    // TC : O(3^n), SC: O(1)
    // edge case n = 9, a = b = c = 2
    public static int getMaxPieces(int n, int a, int b, int c) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;

        int res = Math.max(Math.max(getMaxPieces(n - a, a, b, c), getMaxPieces(n - b, a, b, c)),
                getMaxPieces(n - c, a, b, c));

        if (res == -1)
            return -1;
        return res + 1;
    }
}
