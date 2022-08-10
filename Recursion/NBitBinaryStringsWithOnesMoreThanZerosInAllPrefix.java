
// https://www.geeksforgeeks.org/print-n-bit-binary-numbers-1s-0s-prefixes/
import java.util.*;

class Solution {
    // TC: O(2^n), SC: O(1)
    public static ArrayList<String> NBitBinary(int N) {
        ArrayList<String> res = new ArrayList<>();
        generateNums(res, "", 0, 0, N);
        return res;
    }

    public static void generateNums(ArrayList<String> res, String op, int ones, int zeros, int n) {
        if (op.length() == n) {
            res.add(op);
            return;
        }

        if (ones == zeros) {
            String op1 = op + "1";
            generateNums(res, op1, ones + 1, zeros, n);
        } else if (ones > zeros) {
            String op1 = op + "1";
            String op2 = op + "0";
            generateNums(res, op1, ones + 1, zeros, n);
            generateNums(res, op2, ones, zeros + 1, n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> res = NBitBinary(n);
        System.out.println(res);
    }
}