// https://www.geeksforgeeks.org/trapping-rain-water/
class Solution {
    public static int getRightMax(int[] arr, int start, int end) {
        int rightMax = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++)
            rightMax = Math.max(rightMax, arr[i]);
        return rightMax;
    }

    public static int getLeftMax(int[] arr, int start, int end) {
        int leftMax = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++)
            leftMax = Math.max(leftMax, arr[i]);
        return leftMax;
    }

    // TC : O(n^2), SC: O(1)
    public static int getWaterNaive(int[] arr) {
        int n = arr.length;
        if (n <= 2)
            return 0;
        int water = 0;
        int leftMax = arr[0];
        int rightMax = arr[n - 1];
        for (int i = 1; i <= n - 2; i++) {
            leftMax = getLeftMax(arr, 0, i);
            rightMax = getRightMax(arr, i, n - 1);
            if (Math.min(leftMax, rightMax) - arr[i] > 0)
                water += Math.min(leftMax, rightMax) - arr[i];
        }
        return water;
    }

    // TC: O(n), SC: O(n)
    public static int getWaterEfficient(int[] arr) {
        int n = arr.length;
        if (n <= 2)
            return 0;

        int water = 0;
        int[] leftMaxArr = new int[n];
        int[] rightMaxArr = new int[n];

        int leftMax = arr[0];
        leftMaxArr[0] = leftMax;
        for (int i = 1; i < n; i++) {
            if (arr[i] > leftMax)
                leftMax = arr[i];
            leftMaxArr[i] = Math.max(leftMax, leftMaxArr[i - 1]);
        }

        int rightMax = arr[n - 1];
        rightMaxArr[n - 1] = rightMax;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > rightMax)
                rightMax = arr[i];
            rightMaxArr[i] = Math.max(rightMax, rightMaxArr[i + 1]);
        }

        for (int i = 1; i < n - 1; i++)
            water += Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];

        return water;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 2, 5, 3, 4 };
        int water = getWaterEfficient(arr);
        System.out.println("Total Water: " + water);
    }
}