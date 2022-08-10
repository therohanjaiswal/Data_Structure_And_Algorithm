// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
class Solution {
    // TC: O(m + n), SC: O(1)
    public static boolean matSearch(int[][] mat, int X) {
        int N = mat.length, M = mat[0].length;
        int i = 0, j = M - 1;

        while (i < N && j >= 0) {
            if (mat[i][j] == X)
                return true;
            else if (mat[i][j] < X)
                ++i;
            else
                --j;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = { { 3, 30, 38 }, { 44, 52, 54 }, { 57, 60, 69 } };
        int X = 62;
        if (matSearch(mat, X))
            System.out.println("Element is present.");
        else
            System.out.println("Element is not present.");
    }
}