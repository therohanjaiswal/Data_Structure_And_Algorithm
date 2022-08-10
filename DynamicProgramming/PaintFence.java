// https://www.geeksforgeeks.org/painting-fence-algorithm/
class Solution {
    // TC: O(n), SC: O(1)
    public static long countWays(int n, int k) {
        if (n == 1)
            return k;
        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i < n + 1; ++i) {
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }

        return total;
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(countWays(n, k));
    }
}