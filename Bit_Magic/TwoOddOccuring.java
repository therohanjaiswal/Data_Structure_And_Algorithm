// https://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
class Solution {
    // TC: O(n), SC: O(1)
    public static int[] twoOddNum(int arr[], int n) {
        int xor = 0;
        for (int i = 0; i < n; ++i)
            xor = xor ^ arr[i];

        int s = xor & ~(xor - 1);
        int odd1 = 0, odd2 = 0;

        for (int i = 0; i < n; ++i) {
            if ((arr[i] & s) != 0)
                odd1 = odd1 ^ arr[i];
            else
                odd2 = odd2 ^ arr[i];
        }

        int[] res = new int[2];
        if (odd1 > odd2) {
            res[0] = odd1;
            res[1] = odd2;
        } else {
            res[0] = odd2;
            res[1] = odd1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 4, 5, 2, 3, 3, 1 };
        int n = arr.length;
        int[] res = twoOddNum(arr, n);
        System.out.println("Two numbers with odd occurrences: " + res[0] + " " + res[1]);
    }
}