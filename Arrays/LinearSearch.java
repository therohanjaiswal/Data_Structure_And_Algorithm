// https://www.geeksforgeeks.org/linear-search/
class Solution {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 12, 5, 6 };
        int key = 5;
        System.out.println(linearSearch(arr, key));
    }

    // TC: O(n), SC: O(1)
    public static int linearSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == k)
                return i;

        return -1;
    }
}