// https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?category[]=Recursion&category[]=Recursion&problemStatus=unsolved&difficulty[]=0&difficulty[]=1&page=1&query=category[]RecursionproblemStatusunsolveddifficulty[]0difficulty[]1page1category[]Recursion#
class Solution {
    public static void main(String[] args) {
        int n = 2, k = -3;
        System.out.println(power(n, k));
        System.out.println(powerModulo(12, 21));
    }

    // TC: O(log|n|), SC: O(1)
    // Works for negative power and decimal digits too
    public static float power(float n, int k) {
        float temp;
        if (k == 0) {
            return 1;
        }
        temp = power(n, k / 2);
        if (k % 2 == 0) {
            return temp * temp;
        } else {
            if (k > 0)
                return n * temp * temp;
            else
                return (temp * temp) / n;
        }
    }

    // R is reverse of N
    public static long powerModulo(int N, int R) {
        // Your code here
        if (R == 0)
            return 1;
        long temp = powerModulo(N, R / 2);
        temp = (temp * temp) % 1000000007;
        if (R % 2 != 0) {
            return (temp * N) % 1000000007;
        }
        return temp % 1000000007;
    }
}
