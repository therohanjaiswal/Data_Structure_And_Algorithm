// https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
class Solution {
    // TC: O(nlogn), SC: O(1)
    public static int countSmallerEqualElements(int[][] matrix, int key) {
        int count = 0;

        for (int i = 0; i < matrix.length; ++i) {
            int left = 0, right = matrix[i].length;
            int mid = 0;

            while (left < right) {
                mid = (right + left) >> 1;

                if (matrix[i][mid] == key) {
                    // count duplicates of matrix[i][mid] also
                    while (mid + 1 < matrix[i].length && matrix[i][mid + 1] == key)
                        mid++;
                    break;
                } else if (matrix[i][mid] > key)
                    right = mid;
                else
                    left = mid + 1;
            }

            // this will run, when key is not present in ith row of matrix
            while (mid >= 0 && matrix[i][mid] > key)
                mid--;

            count += mid + 1;
        }

        return count;
    }

    // TC: O(y * nlogn), y = log(abs(Mat[0][0] - Mat[n-1][n-1])), SC: O(1)
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallerEqualToK = countSmallerEqualElements(matrix, mid);

            if (smallerEqualToK < k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 25, 29, 37, 48 },
                { 32, 33, 39, 50 },
        };
        System.out.println("7th smallest element is " + kthSmallest(mat, 7));
    }
}