
// https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[][] m = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        ArrayList<String> res = findPath(m, n);

        for (String s : res)
            System.out.println(s);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        int[][] solMaze = new int[n][n];
        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };
        if (m[0][0] == 1) {
            solve(0, 0, m, n, res, "", solMaze, di, dj);
        }

        return res;
    }

    public static void solve(int i, int j, int[][] m, int n, ArrayList<String> res, String path,
            int[][] solMaze, int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            solMaze[i][j] = 1;
            res.add(path);
            solMaze[i][j] = 0;
            return;
        }

        // if(i + 1 < n && solMaze[i+1][j] == 0 && m[i+1][j] == 1) {
        // solMaze[i][j] = 1;
        // solve(i+1, j, m, n, res, path + "D", solMaze);
        // solMaze[i][j] = 0;
        // }

        // if(j - 1 >= 0 && solMaze[i][j-1] == 0 && m[i][j-1] == 1) {
        // solMaze[i][j] = 1;
        // solve(i, j-1, m, n, res, path + "L", solMaze);
        // solMaze[i][j] = 0;
        // }

        // if(j + 1 < n && solMaze[i][j+1] == 0 && m[i][j+1] == 1) {
        // solMaze[i][j] = 1;
        // solve(i, j+1, m, n, res, path + "R", solMaze);
        // solMaze[i][j] = 0;
        // }

        // if(i - 1 >= 0 && solMaze[i-1][j] == 0 && m[i-1][j] == 1) {
        // solMaze[i][j] = 1;
        // solve(i-1, j, m, n, res, path + "U", solMaze);
        // solMaze[i][j] = 0;
        // }

        // The above method is tedious as we can have more than 4 directions like
        // diagonals,
        // in that case we may have to write 8 cases. So instead of previous method, we
        // can
        // write a loop for the same and make di and dj array

        String dir = "DLRU";

        for (int index = 0; index < dir.length(); ++index) {
            int nexti = i + di[index];
            int nextj = j + dj[index];

            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && solMaze[nexti][nextj] == 0
                    && m[nexti][nextj] == 1) {
                solMaze[i][j] = 1;
                solve(nexti, nextj, m, n, res, path + dir.charAt(index), solMaze, di, dj);
                solMaze[i][j] = 0;
            }
        }
    }
}