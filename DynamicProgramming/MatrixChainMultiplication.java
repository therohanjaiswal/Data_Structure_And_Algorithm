// https://www.youtube.com/watch?v=pEYwLmGJcvs
class Solution {
    public static int matrixMultiplicationRec(int[] arr, int i, int j) {
        // if arr has only 2 elements means only one matrix. So, no multiplications req
        if (i + 1 == j)
            return 0;

        // mChain(arr, i, j) = min(sum(k = i+1 to j-1) mChain(arr, i, k) + mChain(arr,
        // k, j) + arr[i] * arr[k] * arr[j])
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
            res = Math.min(res, matrixMultiplicationRec(arr, i, k) +
                    matrixMultiplicationRec(arr, k, j) + arr[i] * arr[k] * arr[j]);
        }

        return res;
    }

    // TC: O(n^3), SC: O(n^2)
    public static int matrixMultiplicationDp(int arr[], int N) {
        int[][] dp = new int[N - 1][N - 1];
        // N-1 is taken as number of matrix is N-1 for an arr of size N
        for (int i = 0; i < dp.length; ++i)
            dp[i][i] = 0;

        for (int gap = 1; gap < dp.length; ++gap) {
            for (int i = 0, j = gap; j < dp.length; ++i, ++j) {
                if (gap == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {
                    // dp[][] - leftHalf [i, k], rightHalf [k+1, j]
                    // arr[] - leftHalf [i, k+1], rightHalf [k+1, j+1]
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; ++k) {
                        int leftCost = dp[i][k];
                        int rightCost = dp[k + 1][j];
                        int multCost = arr[i] * arr[k + 1] * arr[j + 1];
                        int totalCost = leftCost + rightCost + multCost;
                        dp[i][j] = Math.min(dp[i][j], totalCost);
                    }
                }
            }
        }

        return dp[0][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };
        int n = arr.length;
        System.out.println("Min number of multiplication: " + matrixMultiplicationRec(arr, 0, n - 1));
        System.out.println("Min number of multiplication: " + matrixMultiplicationDp(arr, n - 1));
    }
}