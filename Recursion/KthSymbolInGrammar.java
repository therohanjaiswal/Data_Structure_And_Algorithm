// https://leetcode.com/problems/k-th-symbol-in-grammar/
class Solution {
    // TC: O(n), SC: O(1)
    public static int kthGrammar(int n, int k) {
        if (n == 1 && k == 1)
            return 0;
        int mid = 1 << n - 2;
        if (k <= mid)
            return kthGrammar(n - 1, k);
        return 1 - kthGrammar(n - 1, k - mid);
    }

    public static void main(String[] args) {
        int n = 4, k = 4;
        System.out.print((kthGrammar(n, k));
    }
}