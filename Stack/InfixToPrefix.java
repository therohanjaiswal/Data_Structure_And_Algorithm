import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        // String exp = "(a-b/c)*(a/k-l)";
        String prefix = infixToPrefix(exp);
        System.out.print(prefix);
    }

    // TC: O(n), SC: O(n)
    public static String infixToPrefix(String exp) {
        char[] arr = exp.toCharArray();
        reverse(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == ')')
                arr[i] = '(';
            else if (arr[i] == '(')
                arr[i] = ')';
        }

        String res = infixToPostfix(String.valueOf(arr));
        arr = res.toCharArray();
        reverse(arr, 0, arr.length - 1);
        return String.valueOf(arr);
    }

    public static void reverse(char[] arr, int low, int high) {
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            ++low;
            --high;
        }
    }

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

    public static int prec(char ch) {
        switch (ch) {
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
