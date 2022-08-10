
// https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
import java.util.Stack;

class Solution {
    // TC: O(n^2), SC: O(1)
    public static Stack<Integer> reverseStack(Stack<Integer> st) {
        if (st.size() == 1)
            return st;
        int top = st.pop();
        st = reverseStack(st);
        insert(st, top);
        return st;
    }

    public static void insertAtBottom(Stack<Integer> st, int top) {
        if (st.isEmpty()) {
            st.push(top);
            return;
        }

        int temp = st.pop();
        insertAtBottom(st, top);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(6);
        st.push(3);
        st.push(1);
        st.push(9);
        st.push(10);
        st.push(7);
        System.out.println(st);
        st = reverseStack(st);
        System.out.println(st);
    }
}
