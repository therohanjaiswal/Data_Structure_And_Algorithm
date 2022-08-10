import java.util.*;

class Solution {
    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] M = { { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 } };

        int maxArea = maximalRectangle(M);
        System.out.println(maxArea);
    }

    // TC: O(r * c), SC: O(c)
    public static int maximalRectangle(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int maxArea = maxRectUtils(0, c, mat[0]);
        for (int i = 1; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (mat[i][j] == 1)
                    mat[i][j] += mat[i - 1][j];
            }

            maxArea = Math.max(maxArea, maxRectUtils(i, c, mat[i]));
        }

        return maxArea;
    }

    public static int maxRectUtils(int r, int c, int[] arr) {
        int[] left = getLeftLimit(arr);
        int[] right = getRightLimit(arr);

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < c; ++i)
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * arr[i]);

        return maxArea;
    }

    public static int[] getLeftLimit(int[] heights) {
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

    public static int[] getRightLimit(int[] heights) {
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
}