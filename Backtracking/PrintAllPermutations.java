
// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
import java.util.*;

class Solution {
    // TC: O(n!), SC: O(1)
    public static List<List<Integer>> findPermutationsEfficient(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        findP(nums, res, perm, 0);
        return res;
    }

    public void findP(int[] nums, List<List<Integer>> res, List<Integer> perm, int start) {
        int end = nums.length;
        if (start == end) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = start; i < end; ++i) {
            swap(nums, start, i);
            perm.add(nums[start]);
            findP(nums, res, perm, start + 1);
            perm.remove(perm.size() - 1);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // TC: O(n!), SC: O(n)
    public static List<List<Integer>> findPermutationsNaive(int[] nums) {
        // when we have duplicate letters in a string, we can have same
        // permutations. To avoid repetitions of permutations we use set
        // Eg: [1, 2, 2] will have [2, 2, 1] permutation two times.
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        findPerm(nums, res, perm, freq);

        return res;
    }

    public static void findPerm(int[] nums, List<List<Integer>> res, List<Integer> perm, boolean[] freq) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (freq[i] == false) {
                freq[i] = true;
                perm.add(nums[i]);
                findPerm(nums, res, perm, freq);
                perm.remove(perm.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = findPermutationsNaive(nums);
        for (List<Integer> l : res)
            System.out.println(l);

        res = findPermutationsEfficient(nums);
        for (List<Integer> l : res)
            System.out.println(l);
    }
}