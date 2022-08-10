// https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
// TC: O(R+C)
// brute force: TC: O(R*C) - simply traverse the matrix

public class Solution {
    public static void searchElement(int[][] arr, int key) {
        int i = 0, j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] == key) {
                System.out.print(key + " is present at (" + i + "," + j + ")");
                return;
            } else if (arr[i][j] > key)
                --j;
            else
                ++i;
        }
        System.out.println(key + " not found!");
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int key = 23;
        searchElement(arr, key);
    }
}
