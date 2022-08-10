
// https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
import java.util.*;

class Solution {
    // In this case, only single digit numbers are used
    // TC: O(n), SC: O(n)
    public static int evaluatePostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                st.push(c - '0'); // convert character to integer
            } else {
                int op2 = st.pop();
                int op1 = st.pop();
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

    // This works when there are more than 1 digit numbers too in the expression
    // In this case the digits in the exp are separated by space
    // TC: O(n), SC: O(n)
    public static int evaluatePostfix2(String exp) {
        // exp = "100 200 + 2 / 5 * 7 +";
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ')
                continue;

            // If the scanned character is an operand (number here),
            // extract the number. Push it to the stack.
            else if (Character.isDigit(c)) {
                int num = 0;

                // extract the characters and store it in num
                while (Character.isDigit(c)) {
                    num = num * 10 + (int) (c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                stack.push(num);
            }

            // If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(val2, val1));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        int result = evaluatePostfix(exp);
        System.out.print(result);
    }
}
