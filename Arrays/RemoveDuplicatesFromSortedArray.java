// https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
class Solution {
    // TC: O(n), SC: O(1)
    public static int removeDuplicatesEfficient(int[] arr) {
        if (arr.length == 1)
            return arr.length;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j] != arr[i])
                arr[++j] = arr[i];
        }
        return j + 1;
    }

    // TC: O(n), SC: O(n)
    public static int removeDuplicatesNaive(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return n;

        int[] temp = new int[n];

        int j = 0;
        for (int i = 0; i < n - 1; ++i)
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];
        temp[j++] = arr[n - 1];

        for (int i = 0; i < j; ++i)
            arr[i] = temp[i];

        return j;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 5 };
        int n = arr.length;
        System.out.print("Original Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        n = removeDuplicatesEfficient(arr);
        System.out.print("\nResultant Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
