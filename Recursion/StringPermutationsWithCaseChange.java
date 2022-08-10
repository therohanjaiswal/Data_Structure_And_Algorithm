// https://www.geeksforgeeks.org/permute-string-changing-case/
class Solution {
    public static void permutations(String s) {
        s = s.toLowerCase();
        permutationWithNumbers(s, "", 0);
    }

    public static void permutationsUtils(String ip, String op, int i) {
        if (i == ip.length()) {
            System.out.println(op);
            return;
        }

        char c = ip.charAt(i);
        String op1 = op + c;
        String op2 = op + String.valueOf(c).toUpperCase();
        permutationsUtils(ip, op1, i + 1);
        permutationsUtils(ip, op2, i + 1);
    }

    public static void permutationWithNumbers(String ip, String op, int i) {
        if (i == ip.length()) {
            System.out.println(op);
            return;
        }

        char c = ip.charAt(i);
        String op1 = op + c;
        if (Character.isDigit(c)) {
            permutationWithNumbers(ip, op1, i + 1);
            return;
        }
        String op2 = op + String.valueOf(c).toUpperCase();
        permutationWithNumbers(ip, op1, i + 1);
        permutationWithNumbers(ip, op2, i + 1);
    }

    public static void main(String[] args) {
        String str = "a1b2";
        permutations(str);
    }
}