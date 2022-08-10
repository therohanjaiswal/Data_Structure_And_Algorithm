
// https://www.geeksforgeeks.org/pascal-triangle/
import java.util.*;

class Solution {
    // TC: O(n^2), Sc: O(1)
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        res.add(arr);

        for (int i = 1; i < numRows; ++i) {
            arr = new ArrayList<>();
            // adding 0th element of ith row
            arr.add(1);

            // adding intermediate elements of ith row
            List<Integer> temp = res.get(i - 1);
            int idx = 1;
            while (idx < temp.size()) {
                int a = temp.get(idx - 1);
                int b = temp.get(idx);
                arr.add(a + b);
                ++idx;
            }

            // adding last element of ith row
            arr.add(1);

            res.add(arr);
        }

        return res;
    }

    public static void main(String[] args) {
        int row = 4;
        List<List<Integer>> res = generatePascalTriangle(row);
        System.out.print(res);
    }
}