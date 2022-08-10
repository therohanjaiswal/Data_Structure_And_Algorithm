// https://www.geeksforgeeks.org/lucky-numbers/
class Solution {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isLucky(n));
    }

    public static boolean isLucky(int n) {
        return check(n, 2);
    }

    // TC: O(n), SC: O(1)
    public static boolean check(int n, int counter) {
        if (counter > n)
            return true;
        if (n % counter == 0)
            return false;
        n = n - n / counter;
        counter++;
        return check(n, counter);
    }
}
