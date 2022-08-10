// https://www.geeksforgeeks.org/lexicographically-next-permutation-in-cpp/
class Solution {
    // TC: O(n), SC: O(1)
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind1 = -1, ind2 = n - 1;

        // step 1: find the index which is smaller than the higher point
        // while traversing from end
        for (int i = n - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                ind1 = i - 1;
                break;
            }
        }

        // if the elements are in decreasing order then ind1 will be -1.
        // if the elements are not in decreasing order, then below is true.
        if (ind1 != -1) {
            // step 2: find the element just greater than nums[ind1]
            for (int i = n - 1; i > ind1; --i) {
                if (nums[i] > nums[ind1]) {
                    ind2 = i;
                    break;
                }
            }
            swap(nums, ind1, ind2);
        }

        // step 3: reverse nums from ind1+1 to n-1
        reverse(nums, ind1 + 1, n - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int low, int high) {
        while (low < high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            ++low;
            --high;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1 };
        int[] res = nextPermutation(arr);
        for (int i : res)
            System.out.print(i + " ");
    }
}