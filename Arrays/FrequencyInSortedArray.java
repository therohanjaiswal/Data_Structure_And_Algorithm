// https://www.geeksforgeeks.org/find-the-frequency-of-each-element-in-a-sorted-array/

class Solution {
    // TC: O(n), SC: O(1)
    public static void frequencyCount(int[] arr) {
        int n = arr.length;
        int j = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[j] != arr[i]) {
                System.out.println(arr[j] + "-" + count);
                j = i;
                count = 1;
            } else {
                ++count;
            }
        }
        System.out.println(arr[j] + "-" + count);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 3, 4, 5, 5, 6 };
        frequencyCount(arr);
    }
}
