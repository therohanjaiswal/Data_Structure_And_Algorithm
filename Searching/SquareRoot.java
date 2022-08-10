// https://www.geeksforgeeks.org/square-root-of-an-integer/

class Solution {
    // TC: O(logx), SC: O(1)
    public static int squareRoot(int x) {
        int low = 1, high = x, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int mSq = mid * mid;
            if (mSq == x)
                return mid;
            else if (mSq > x)
                high = mid - 1;
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println("Square root of " + x + ": " + squareRoot(x));
    }
}
