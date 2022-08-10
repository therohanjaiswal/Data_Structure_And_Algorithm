
// https://www.geeksforgeeks.org/maximum-occurred-integer-n-ranges/
import java.util.*;

class Solution {
    static int MAX = 1000000;

    // This works only if the maximum limit is less than equal to MAX
    // Prefix Sum Technique, TC: O(n + MAX), SC: O(MAX)
    public static int maxOccurredElementEfficient(int L[], int R[], int n) {
        int[] arr = new int[MAX];
        Arrays.fill(arr, 0);
        for (int i = 0; i < n; i++) {
            arr[L[i]] += 1;
            arr[R[i] + 1] -= 1;
        }

        int maxFrequency = arr[0];
        int index = 0;
        for (int i = 1; i < MAX; i++) {
            arr[i] += arr[i - 1];
            if (maxFrequency < arr[i]) {
                maxFrequency = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] L = { 1, 4, 9, 13, 21 };
        int[] R = { 15, 8, 12, 20, 30 };
        int n = L.length;
        System.out.println(maxOccurredElementEfficient(L, R, n));
    }
}
