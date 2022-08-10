public class Solution {

    public static void spiralTraverse(int[][] arr) {
        if (arr.length == 1) {
            for (int i = 0; i < arr[0].length; ++i)
                System.out.print(arr[0][i] + " ");
            return;
        }

        if (arr[0].length == 1) {
            for (int i = 0; i < arr.length; ++i)
                System.out.print(arr[i][0] + " ");
            return;
        }

        int top = 0, right = arr[0].length - 1, bottom = arr.length - 1, left = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; ++i)
                System.out.print(arr[top][i] + " ");
            ++top;
            for (int i = top; i <= bottom; ++i)
                System.out.print(arr[i][right] + " ");
            --right;
            for (int i = right; i >= left; --i)
                System.out.print(arr[bottom][i] + " ");
            --bottom;
            for (int i = bottom; i >= top; --i)
                System.out.print(arr[i][left] + " ");
            ++left;
        }
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };
        int[][] arr = { { 1 }, { 2 }, { 3 } };
        System.out.println("Original Matrix: ");
        printMatrix(arr);
        System.out.println("Spiral Traversal: ");
        spiralTraverse(arr);
    }

}