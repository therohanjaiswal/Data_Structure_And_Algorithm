
// https://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
import java.util.ArrayList;

class Solution {
    public static ArrayList<String> permutation(String S) {
        ArrayList<String> res = new ArrayList<>();
        int length = S.length();
        if (length <= 1) {
            res.add(S);
            return res;
        }
        permutationsUtils(res, S.substring(1, length), S.substring(0, 1));
        Collections.sort(res);
        return res;
    }

    public static void permutationsUtils(ArrayList<String> res, String ip, String op) {
        if (ip.length() == 0) {
            res.add(op);
            return;
        }
        char c = ip.charAt(0);
        ip = ip.substring(1, ip.length());
        permutationsUtils(res, ip, op + c);
        permutationsUtils(res, ip, op + " " + c);
    }

    public static void main(String[] args) {
        String str = "ABC";
        ArrayList<String> arr = permuatations(str);
    }
}