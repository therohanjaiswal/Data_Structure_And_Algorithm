
// https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/
import java.util.ArrayList;

class Solution {
    // TC: O(2^n), Sc: O(2^n)
    public static ArrayList<ArrayList<Integer>> subsetsRecursive(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsetsRecursiveUtils(result, A, new ArrayList<Integer>(), 0);
        return result;
    }

    public static void subsetsRecursiveUtils(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr,
            ArrayList<Integer> output,
            int index) {
        if (index == arr.size()) {
            res.add(output);
            return;
        }

        subsetsRecursiveUtils(res, arr, new ArrayList<>(output), index + 1);
        output.add(arr.get(index));
        subsetsRecursiveUtils(res, arr, new ArrayList<>(output), index + 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ArrayList<ArrayList<Integer>> result = subsetsRecursive(arr);
    }
}