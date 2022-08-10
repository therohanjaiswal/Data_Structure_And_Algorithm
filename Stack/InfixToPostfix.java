
// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = infixToPostfix(exp);
        System.out.print(postfix);
    }

    // TC: O(n), SC: O(n)
    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        String result = "";
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    result += st.pop();
                st.pop(); // remove ( from stack
            } else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek()))
                    result += st.pop();
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(')
                return "Invalid Expression";
            result += st.pop();
        }
        return result;
    }

    public static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
