
// https://www.geeksforgeeks.org/previous-greater-element/
import java.util.Stack;

class Solution {
    // TC: O(n), SC: O(1)
    public static void prevGreatest(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int span = -1;
        System.out.print(span + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            span = st.isEmpty() ? -1 : arr[st.peek()];
            System.out.print(span + " ");
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 15, 10, 18, 12, 4, 6, 2, 8 };
        prevGreatest(arr);
    }
}
