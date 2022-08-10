
// https://www.geeksforgeeks.org/delete-middle-element-stack/
import java.util.Stack;

class Solution {
    // Tc: O(n), SC: O(1)
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        int middle = (int) Math.ceil(sizeOfStack / 2);
        deleteMidUtils(s, 0, middle);
    }

    public void deleteMidUtils(Stack<Integer> s, int k, int middle) {
        int top = s.pop();
        if (k == middle) {
            return;
        }
        deleteMidUtils(s, k + 1, middle);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        deleteMid(st, 5);
    }
}