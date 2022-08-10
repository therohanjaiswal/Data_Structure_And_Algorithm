// https://www.geeksforgeeks.org/sudoku-backtracking-7/
class Solution {
    public static void main(String[] args) {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        Solution sol = new Solution();
        sol.solveSudoku(board);
    }

    // TC: O(9^n*n), SC: O(1)
    public void solveSudoku(char[][] board) {
        sudokuSolver(board);

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public boolean sudokuSolver(char[][] board) {
        int n = board.length;

        // finding empty grid
        int row = 0, col = 0;
        boolean isEmpty = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
            }

            if (isEmpty)
                break;
        }

        // if there is no empty grid, means sudoku is complete
        if (!isEmpty)
            return true;

        // filling the empty grid with numbers from 1 to 9 and checking whether
        // it is safe or not
        for (int num = 1; num <= 9; ++num) {
            // converts int to char. 10 means decimal system
            char cnum = Character.forDigit(num, 10);
            if (isSafe(board, row, col, cnum)) {
                board[row][col] = cnum;
                if (sudokuSolver(board))
                    return true;
                else
                    board[row][col] = '.';
            }
        }

        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char num) {
        int n = board.length;
        for (int j = 0; j < n; ++j)
            if (board[row][j] == num)
                return false;

        for (int i = 0; i < n; ++i)
            if (board[i][col] == num)
                return false;

        int sqrt = (int) Math.sqrt(n);
        int boxRowStart = row / sqrt * sqrt;
        int boxColStart = col / sqrt * sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; ++r) {
            for (int c = boxColStart; c < boxColStart + sqrt; ++c) {
                if (board[r][c] == num)
                    return false;
            }
        }

        return true;
    }
}