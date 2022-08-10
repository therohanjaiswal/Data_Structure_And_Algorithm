
// https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
import java.util.ArrayList;

class Solution {
    // TC: O(2^n), SC: O(n)
    public static ArrayList<String> genBalParen(int n) {
        ArrayList<String> res = new ArrayList<>();
        int open = n, close = n;
        genBalParenUtils(res, "", open, close);
        return res;
    }

    public static void genBalParenUtils(ArrayList<String> res, String op, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(op);
            return;
        }

        // chance for opening bracket
        if (open != 0) {
            String op1 = op + "(";
            genBalParenUtils(res, op1, open - 1, close);
        }

        // chance for closing bracket
        if (open < close) {
            String op2 = op + ")";
            genBalParenUtils(res, op2, open, close - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> res = genBalParen(n);
        System.out.println(res);
    }
}