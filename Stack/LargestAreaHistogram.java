// https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/

class Solution {
    // TC: O(n), SC: O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = getLeftLimit(heights);
        int[] right = getRightLimit(heights);

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            // current area is the area computed by taking full height[i]
            int currArea = (right[i] - left[i] + 1) * heights[i];
            maxArea = Math.max(maxArea, currArea);

        }

        return maxArea;
    }

    public int[] getLeftLimit(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] left = new int[heights.length];
        left[0] = 0;
        st.push(0);
        for (int i = 1; i < heights.length; ++i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }

        return left;
    }

    public int[] getRightLimit(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] right = new int[n];
        right[n - 1] = n - 1;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; --i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        return right;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 };
        int maxArea = largestRectangleArea(arr);
        System.out.println(maxArea);
    }
}