
// https://www.geeksforgeeks.org/the-stock-span-problem/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(1)
    public static int[] printSpan(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        out[0] = 1;

        for (int i = 1; i < n; ++i) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();

            // when ith element is greater than all the previous elements
            // i.e., greater than even the oth element then stack becomes
            // empty and span is i + 1.
            out[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        return out;
    }

    public static void main(String[] args) {
        int[] arr = { 13, 15, 12, 14, 16, 8, 6, 4, 10, 30 };

        int[] out = printSpan(arr);
        for (int i : out) {
            System.out.print(i + " ");
        }
    }
}
