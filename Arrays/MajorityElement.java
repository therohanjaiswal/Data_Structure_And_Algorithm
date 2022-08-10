// https://www.geeksforgeeks.org/majority-element/
class Solution {
    public static int getCandidate(int[] arr) {
        int val = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (val == arr[i])
                ++count;
            else
                --count;
            if (count == 0) {
                val = arr[i];
                count = 1;
            }
        }
        return val;
    }

    // Moore's Vooting Algorithm
    // TC: O(n), SC: O(1)
    public static int findMajorityElement(int[] arr) {
        int n = arr.length;
        int candidate = getCandidate(arr);
        int count = 0;
        for (int a : arr)
            if (a == candidate)
                ++count;

        if (count >= n / 2)
            return candidate;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 6 };
        int result = findMajorityElement(arr);
        if (result == -1)
            System.out.println("No majority element present.");
        else
            System.out.println("Majority Element: " + result);
    }
}
