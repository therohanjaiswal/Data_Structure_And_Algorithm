// https://www.geeksforgeeks.org/two-pointers-technique/
class Solution {
    // Two Pointer Technique, TC: O(n), SC: O(1)
    public static boolean findPair(int[] arr, int sum) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int currSum = arr[low] + arr[high];
            if (currSum == sum) {
                System.out.println("Index Pair: " + low + " & " + high);
                return true;
            } else if (currSum > sum)
                --high;
            else
                ++low;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 30 };
        int sum = 17;
        System.out.println(findPair(arr, sum));
    }
}
