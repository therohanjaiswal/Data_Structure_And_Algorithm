// https://www.geeksforgeeks.org/split-array-three-equal-sum-subarrays/
class Solution {
    // TC: O(n), SC: O(1)
    public boolean canThreePartsEqualSum(int[] arr) {
        int arrSum = 0;
        for (int i : arr)
            arrSum += i;

        if (arrSum % 3 != 0)
            return false;

        int preSum = 0, idx1 = -1, idx2 = -1;
        int s1 = arrSum / 3;
        int s2 = 2 * s1;

        // Loop until second last index as s2 should not be at the last
        for (int i = 0; i < arr.length - 1; ++i) {
            preSum += arr[i];

            if (preSum == s1 && idx1 == -1) {
                idx1 = i;
            } else if (preSum == s2 && idx1 != -1) {
                idx2 = i;
                break;
            }
        }

        if (idx1 != -1 && idx2 != -1) {
            System.out.print("(" + idx1 + ", " + idx2 + ")");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
        System.out.println(canThreePartsEqualSum(arr));
    }
}