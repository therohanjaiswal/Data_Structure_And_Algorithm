// https://www.geeksforgeeks.org/a-product-array-puzzle/
class Solution {
    // TC: O(n), SC: O(n)
    public static int[] productExceptItselfNaive(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        for (int i = 0; i < n; ++i)
            answer[i] = prefix[i] * suffix[i];

        return answer;
    }

    // TC: O(n), SC: O(1)
    public static int[] productExceptItselfEfficient(int[] arr) {
        int n = arr.length;
        int zeroCount = 0;
        int product = 1;
        for (int i : arr) {
            if (i == 0)
                ++zeroCount;
            else
                product *= i;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            if (zeroCount > 1)
                ans[i] = 0;
            else if (zeroCount == 0)
                ans[i] = product / arr[i];
            else if (zeroCount == 1 && arr[i] != 0)
                ans[i] = 0;
            else // flag == 1 && a[i] == 0
                ans[i] = product;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 1, 0, -3, 3 };
        int[] ans = productExceptItselfEfficient(arr);
        for (int i : ans)
            System.out.print(i + " ");
    }
}