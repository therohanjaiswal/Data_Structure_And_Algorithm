
//https://www.geeksforgeeks.org/next-greater-element/
import java.util.Stack;

class Solution {
    // TC: O(n), SC: O(n)
    public static void nextGreater(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(arr[n - 1]);
        int nextGreater = -1;
        System.out.print(nextGreater + " ");
        for (int i = n - 2; i >= 0; --i) {
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            nextGreater = st.isEmpty() ? -1 : st.peek();
            System.out.print(nextGreater + " ");
            st.push(arr[i]);
        }
    }

    // TC: O(n), SC: O(n)
    public static void nextGreaterCircular(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i % n])
                st.pop();
            res[i % n] = st.isEmpty() ? -1 : nums[st.peek()];
            st.push(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
        nextGreater(arr);
    }
}