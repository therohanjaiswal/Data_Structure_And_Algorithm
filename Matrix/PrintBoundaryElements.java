public class Solution {
    public static void printBoundary(int[][] arr) {
        // to handle duplicates in print
        if (arr.length == 1) { // when matrix has single row
            for (int i = 0; i < arr[0].length; ++i)
                System.out.print(arr[0][i] + " ");
        } else if (arr[0].length == 1) { // when matrix has single column
            for (int i = 0; i < arr.length; ++i)
                System.out.print(arr[i][0] + " ");
        } else {
            for (int i = 0; i < arr[0].length; ++i)
                System.out.print(arr[0][i] + " ");
            for (int i = 1; i < arr.length; ++i)
                System.out.print(arr[i][arr[0].length - 1] + " ");
            for (int i = arr[arr.length - 1].length - 2; i >= 0; --i)
                System.out.print(arr[arr.length - 1][i] + " ");
            for (int i = arr.length - 2; i >= 1; --i)
                System.out.print(arr[i][0] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        // edge cases
        // int[][] arr = { { 1, 2, 3 } };
        // int[][] arr = { { 1 }, { 2 }, { 3 } };
        printBoundary(arr);
    }
}
