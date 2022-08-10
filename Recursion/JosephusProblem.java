// https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
class Solution {
    public static void main(String[] args) {
        int n = 5, k = 3;
        System.out.println(josephus(n, k));
    }

    // for positions [0, n-1], take
    // josephus(n, k) = (josephus(n-1, k) + k) % n;
    // Here, position starts from 1 to n.
    // TC: O(n), SC: O(1)
    public static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        return (josephus(n - 1, k) + k - 1) % n;
    }
}
