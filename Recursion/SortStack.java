
// https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
import java.util.*;

class Solution {

    // TC: O(n*n), SC: O(n)
    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.size() == 1)
            return s;
        int top = s.pop();
        sort(s);
        insert(s, top);
        return s;
    }

    public static void insert(Stack<Integer> s, int x) {
        if (s.isEmpty() || s.peek() < x) {
            s.push(x);
            return;
        }
        int top = s.pop();
        insert(s, x);
        s.push(top);

    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(6);
        st.push(3);
        st.push(1);
        st.push(9);
        st.push(10);
        st.push(7);
        st = sort(st);
        System.out.println(st);
    }
}