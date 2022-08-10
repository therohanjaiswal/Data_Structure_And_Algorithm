
// https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(n)
    public static boolean isBalanced(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty() || !isMatching(st.peek(), c))
                    return false;
                else
                    st.pop();
            }
        }

        // if in the end the stack is not empty in cases like "[[[[["
        // return false as the loop performs only push operation
        return st.isEmpty() ? true : false;
    }

    public static boolean isMatching(char a, char b) {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }

    public static void main(String[] args) {
        String str = "{[()]}";

        if (isBalanced(str))
            System.out.println("Balanced");
        else
            System.out.println("Unbalanced.");
    }
}
