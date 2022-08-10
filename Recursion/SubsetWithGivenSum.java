// https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
class Solution {
    // TC: O(2^n), SC: O(1)
    public static int findSubsets(int[] arr, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;
        return findSubsets(arr, n - 1, sum) + findSubsets(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 15 };
        int sum = 25;
        System.out.println(findSubsets(arr, arr.length, sum));
    }
}
