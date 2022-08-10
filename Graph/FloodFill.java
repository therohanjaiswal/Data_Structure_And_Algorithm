// https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
class Solution {
    // TC: O(m * n), SC: O(1)
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length;
        int n = image[0].length;

        dfs(image, sr, sc, m, n, color, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int m, int n, int color, int col) {
        if (sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != col)
            return;

        image[sr][sc] = color;

        for (int[] d : dirs) {
            int ni = sr + d[0];
            int nj = sc + d[1];

            dfs(image, ni, nj, m, n, color, col);
        }
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        Solution sol = new Solution();
        image = sol.floodFill(image, sr, sc, color);
        for (int i = 0; i < image.length; ++i) {
            for (int j = 0; j < image[i].length; ++j)
                System.out.print(image[i][j] + " ");
            System.out.println();
        }
    }
}