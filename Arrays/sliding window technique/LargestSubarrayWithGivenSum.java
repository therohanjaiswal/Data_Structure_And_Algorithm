// https://www.geeksforgeeks.org/find-subarray-with-given-sum/
class Solution {
    // Array must contain non-negative integers
    // TC: O(n), SC: O(1)
    public static int findSubarray(int[] arr, int k) {
        int largest = 0;
        int sum = 0;
        int start = 0;
        for (int end = 0; end <= arr.length; end++) {
            sum += arr[end];
            if (sum == k)
                largest = Math.max(largest, end - start + 1);
            else if (sum > k) {
                while (currSum > sum && start < end - 1) {
                    currSum -= arr[start];
                    start++;
                }
                if (sum == k)
                    largest = Math.max(largest, end - start + 1);
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
                154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
        int sum = 468;
        System.out.println(findSubarray(arr, sum));
    }
}
