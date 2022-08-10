
// https://leetcode.com/problems/basic-calculator-ii/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(1)
    public static int calculateEfficient(String s) {
        int n = s.length();
        int res = 0, lastNo = 0, currNo = 0;
        char sign = '+';

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNo = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    currNo = currNo * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                --i; // important

                if (sign == '+' || sign == '-') {
                    res += lastNo;
                    lastNo = sign == '+' ? currNo : -currNo;
                } else if (sign == '*') {
                    lastNo = lastNo * currNo;
                } else if (sign == '/')
                    lastNo = lastNo / currNo;
            } else if (c != ' ')
                sign = c;
        }
        res += lastNo;

        return res;
    }

    // TC: O(n), SC: O(n)
    public static int calculateNaive(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        char sign = '+';
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    ++i;
                }
                --i; // important

                if (sign == '+')
                    st.push(num);
                else if (sign == '-')
                    st.push(-num);
                else if (sign == '*')
                    st.push(st.pop() * num);
                else if (sign == '/')
                    st.push(st.pop() / num);
            } else if (c != ' ')
                sign = c;
        }

        int res = 0;
        while (!st.isEmpty())
            res += st.pop();

        return res;
    }

    public static void main(String[] args) {
        String str = "3 + 2 * 2";
        System.out.println(calculateEfficient(str));
    }
}