
// https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(n^2)
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n) {
        int[][] dirs = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 } };
        int steps = 0;
        int x = KnightPos[0] - 1, y = KnightPos[1] - 1;
        int tx = TargetPos[0] - 1, ty = TargetPos[1] - 1;
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair curr = q.remove();

                int xx = curr.x;
                int yy = curr.y;

                if (xx == tx && yy == ty)
                    return steps;

                for (int i = 0; i < 8; ++i) {
                    int nx = xx + dirs[i][0];
                    int ny = yy + dirs[i][1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        q.add(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            ++steps;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] knightPos = { 4, 5 };
        int[] targetPos = { 1, 1 };
        int n = 6;

        Solution sol = new Solution();
        System.out.println(sol.minStepToReachTarget(knightPos, targetPos, n));
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}