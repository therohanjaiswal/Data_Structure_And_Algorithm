// https://www.geeksforgeeks.org/program-for-sum-of-the-digits-of-a-given-number/
class Solution {
    public static void main(String[] args) {
        int n = 99999;
        System.out.println(sumOfDigits(n));
    }

    // TC: O(n), SC: O(n)
    public static int sumOfDigits(int n) {
        if (n == 0)
            return 0;
        return n % 10 + sumOfDigits(n / 10);
    }
}
