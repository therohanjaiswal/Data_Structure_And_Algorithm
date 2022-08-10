
// https://www.geeksforgeeks.org/find-repeating-element-sorted-array-size-n/
import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    // TC: O(n), SC: O(n)
    public static int findElementNaive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; ++i) {
            if (visited[arr[i]] == true)
                return arr[i];
            visited[arr[i]] = true;
        }

        return -1;
    }

    // Only one repeating element, inplace, 0 <= max(arr) <= n-2
    // TC: O(n), SC: O(1)
    public static int findElementEfficient(int[] arr) {
        int slow = arr[0] + 1, fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast]] + 1;
        } while (slow != fast);

        slow = arr[0] + 1;
        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }

        return slow - 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 3, 3 };
        System.out.println("Repeating element: " + findElementNaive(arr));
        System.out.println("Repeating element: " + findElementEfficient(arr));
    }
}