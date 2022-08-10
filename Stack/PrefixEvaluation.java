
// https://www.geeksforgeeks.org/evaluation-prefix-expressions/
import java.util.*;

class Solution {
    // This works when there are more than 1 digit numbers too in the expression
    // In this case the digits in the exp are separated by space
    // TC: O(n), SC: O(n)
    public static int evaluatePrefix(String exp) {
        // exp = "+ 9 * 12 6";
        Stack<Integer> st = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; --i) {
            char c = exp.charAt(i);
            // if char is white space
            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                // if char is a more than 1 digit number
                int j = i; // i is start pointer of digit and j is end pointer of digit
                while (i < exp.length() && Character.isDigit(exp.charAt(i)))
                    --i;
                i++;
                int num = 0;
                for (int k = i; k <= j; ++k)
                    num = num * 10 + (exp.charAt(k) - '0');
                st.push(num);
            } else {
                int op1 = st.pop();
                int op2 = st.pop();
                if (c == '+')
                    st.push(op1 + op2);
                else if (c == '-')
                    st.push(op1 - op2);
                else if (c == '*')
                    st.push(op1 * op2);
                else if (c == '/')
                    st.push(op1 / op2);
                else if (c == '^')
                    st.push((int) Math.pow(op1, op2));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String exp = "+ 9 * 12 6";
        System.out.print(evaluatePrefix(exp));
    }
}