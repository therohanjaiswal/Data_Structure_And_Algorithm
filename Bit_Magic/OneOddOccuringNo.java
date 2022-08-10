// https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
class SOlution {
    // TC: O(n), SC: O(1)
    public static int findSingle(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; ++i)
            res = res ^ arr[i];
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 3, 1, 3 };
        int n = arr.length;
        System.out.println("The odd element is: " + findSingle(arr, n));
    }
}