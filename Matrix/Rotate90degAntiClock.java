class Solution {
    public static void rotate90Naive(int[][] arr) {
        int n = arr.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                temp[i][j] = arr[j][n - 1 - i];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                arr[i][j] = temp[i][j];
    }

    public static void transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

    }

    public static void reverseColumn(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int low = 0, high = n - 1;
            while (low < high) {
                int temp = arr[low][i];
                arr[low][i] = arr[high][i];
                arr[high][i] = temp;
                ++low;
                --high;
            }
        }
    }

    public static void rotate90Efficient(int[][] arr) {
        transpose(arr);
        reverseColumn(arr);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Original Matrix: ");
        printMatrix(arr);
        // rotate90Naive(arr);
        rotate90Efficient(arr);
        System.out.println("After anticlock 90 deg rotation: ");
        printMatrix(arr);
    }
}
