// https://www.youtube.com/watch?v=2JSQIhPcHQg
class Solution {
    // TC: O(2^n), SC: O(1)
    public static int findPagesRec(int[] arr, int n, int k) {
        if (n == 1)
            return arr[0];
        if (k == 1)
            return sum(arr, 0, n - 1);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            result = Math.min(result, Math.max(findPagesRec(arr, i, k - 1), sum(arr, i, n - 1)));
        }

        return result;
    }

    private static int sum(int[] arr, int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; ++i)
            sum += arr[i];

        return sum;
    }

    // TC: O(n^3 * k), SC: O(n*k)
    // TC can be reduced by precomputing sum of all [i, j] in n^2 matrix, in that
    // case TC: O(n^2*k), SC: O(n*k + n^2) = O(n^2)
    public static int findPagesDp(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < n + 1; ++i)
            dp[1][i] = sum(arr, 0, i - 1);
        for (int i = 1; i < k + 1; ++i)
            dp[i][1] = arr[0];

        for (int i = 2; i < k + 1; ++i) {
            for (int j = 2; j < n + 1; ++j) {
                int res = Integer.MAX_VALUE;
                for (int p = 1; p < j; ++p) {
                    res = Math.min(res, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
                }
                dp[i][j] = res;
            }
        }

        return dp[k][n];
    }

    // TC: O(nLogn), SC: O(1)
    public static int findPagesBinarySearch(int[] A, int N, int M) {
        int sum = 0, max = 0;
        for (int i = 0; i < N; ++i) {
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        int low = max, high = sum, res = -1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (isFeasible(A, N, M, mid)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;
    }

    public static boolean isFeasible(int[] arr, int n, int m, int ans) {
        int requiredStudents = 1, sum = 0;
        for (int i = 0; i < n; ++i) {
            if (sum + arr[i] <= ans) {
                sum += arr[i];
            } else {
                sum = arr[i];
                ++requiredStudents;
            }
        }

        return requiredStudents <= m;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 67, 90 };
        int k = 2; // no of students
        System.out.println("Minimum number of pages = " + findPagesRec(arr, arr.length, k));
        System.out.println("Minimum number of pages = " + findPagesDp(arr, arr.length, k));
        System.out.println("Minimum number of pages = " + findPagesBinarySearch(arr, arr.length, k));
    }
}