
// https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        List<List<String>> res = sol.solveNQueens(n);

        for (List<String> l : res)
            System.out.println(l);
    }

    // TC: O(n!), SC: O(n^2)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] board = new int[n][n];

        nQueenUtil(board, res, 0);

        return res;
    }

    private void nQueenUtil(int[][] board, List<List<String>> res, int row) {
        if (row == board.length) {
            res.add(storeResult(board));
            return;
        }

        for (int col = 0; col < board.length; ++col) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                nQueenUtil(board, res, row + 1);
                board[row][col] = 0;
            }
        }

        // here, instead of
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; --i)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; --i, ++j)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private List<String> storeResult(int[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            String str = "";
            for (int j = 0; j < board.length; ++j) {
                if (board[i][j] == 1)
                    str += "Q";
                else
                    str += ".";
            }
            res.add(str);
        }

        return res;
    }
}