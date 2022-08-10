// https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n0156/1/
class Solution {
    // TC: O(logn), SC: O(1)
    public static int minSteps(int n) {
        if (n == 1)
            return 0;

        // if n is a multiple of 3, I will go to node n/3
        if (n % 3 == 0)
            return 1 + minSteps(n / 3);

        // if n is not a multiple of 3, I will go to node n-1
        return 1 + minSteps(n - 1);
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(minSteps(n));
    }
}