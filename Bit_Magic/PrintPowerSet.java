
// https://www.geeksforgeeks.org/power-set/
import java.util.*;

class Solution {
    // TC: O(n*2^n), SC: O(n)
    public static ArrayList<String> powerSet(String s) {
        ArrayList<String> res = new ArrayList<>();
        int n = s.length();
        int powerSetSize = (int) Math.pow(2, n);

        for (int counter = 0; counter < powerSetSize; ++counter) {
            String temp = "";
            for (int j = 0; j < n; ++j) {
                if ((counter & (1 << j)) != 0)
                    temp += s.charAt(j);
            }
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(powerSet(str));
    }
}