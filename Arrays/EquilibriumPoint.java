// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
class Solution {
    // TC: O(n), SC: O(1)
    public static int equilibirumPointEfficient(int[] arr) {
        int n = arr.length;
        int arrSum = 0;
        for (int i = 0; i < n; i++)
            arrSum += arr[i];

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = arrSum - leftSum - arr[i];
            if (leftSum == arrSum - arr[i])
                return i;
            leftSum += arr[i];
        }

        return -1;
    }

    // TC: O(n), SC:(n)
    public static int equilibriumPointBetter(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0)
                prefixSum[i] = 0;
            else
                prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1)
                suffixSum[i] = 0;
            else
                suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        for (int i = 0; i < n; i++)
            if (prefixSum[i] == suffixSum[i])
                return i;

        return -1;
    }

    // TC: O(n^2), SC: O(1)
    public static int equilibriumPointNaive(int[] arr) {
        int leftSum = 0, rightSum = 0;
        for(int i = 0; i< arr.length; i++) {
            leftSum = 0;
            for(int j = 0; j < i; j++) 
                leftSum += arr[j];
            
            rightSum = 0;
            for(int j = i+1; j < arr.length; i++) 
                rightSum += arr[j]

            if(leftSum == rightSum)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int eqPoint = naiveApproach(arr);
        System.out.println(eqPoint);
    }
}
