
// https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
import java.util.*;

class Solution {
    // TC: O(n^2), SC: O(1)
    public static void getFirstNegativeIntNaive(int arr[], int k) {
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < (n - k + 1); i++) {
            flag = false;
            for (int j = 0; j < k; j++) {
                if (arr[i + j] < 0) {
                    System.out.print((arr[i + j]) + " ");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.print("0" + " ");
        }
    }

    // TC: O(n), SC: O(1)
    public static int[] getFirstNegativeIntEfficient(int arr[], int n, int k) {
        int[] res = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int start = 0, end;

        for (end = 0; end < k; ++end)
            if (arr[end] < 0)
                list.add(arr[end]);

        res[0] = !list.isEmpty() ? list.get(0) : 0;
        int index = 1;
        for (; end < n; ++end) {
            if (!list.isEmpty() && list.get(0) == arr[start])
                list.remove(0);

            if (arr[end] < 0)
                list.add(arr[end]);

            res[index++] = !list.isEmpty() ? list.get(0) : 0;
            start++;
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        getFirstNegativeIntNaive(arr, k);
        System.out.println();
        int[] res = getFirstNegativeIntEfficient(arr, arr.length, k);
        for (int i : res)
            System.out.print(i + " ");
    }
}
