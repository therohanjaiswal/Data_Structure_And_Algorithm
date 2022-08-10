// https://www.geeksforgeeks.org/find-the-missing-number/
class Solution {
    // TC: O(n), SC: O(1)
    public static int missingNumber(int[] arr, int n) {
        int res = 0;
        for (int a : arr)
            res = res ^ a;

        for (int i = 1; i <= n; ++i)
            res = res ^ i;

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 3, 7, 8 };
        int n = 8;
        System.out.println("Missing number: " + missingNumber(arr, n));
    }
}