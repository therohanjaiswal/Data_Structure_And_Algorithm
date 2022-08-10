import java.util.Arrays;

// https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/
// TC: O(r * log(max - min) * log(c))
// odd number of elements are taken i.e., r*c is odd
public class Solution {
    public static int findMedian(int[][] arr) {
        int r = arr.length, c = arr[0].length;
        int min = arr[0][0], max = arr[0][c - 1];
        for (int i = 1; i < r; ++i) {
            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][c - 1]);
        }

        int medPos = (r * c + 1) / 2;

        while (min < max) {
            int mid = (min + max) / 2, midPos = 0;
            for (int i = 0; i < r; ++i) {
                int pos = Arrays.binarySearch(arr[i], mid) + 1;
                midPos += Math.abs(pos);
            }

            if (midPos < medPos)
                min = midPos + 1;
            else
                max = midPos;
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 9, 10, 11, 12 }, { 5, 6, 7, 8 }, { 13, 14, 15, 16 } };
        int med = findMedian(arr);
        System.out.print(med);
    }

}