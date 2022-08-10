// https://www.geeksforgeeks.org/n3-repeated-number-array-o1-space/
class Solution {
    // TC: O(n), SC: O(1)
    // Modification of Moore Voting Algorithm
    public static int moreThanNBy3(int[] arr, int k) {
        int n = arr.length;
        int count1 = 0, count2 = 0;
        int cand1 = -1, cand2 = -1;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == cand1)
                ++count1;
            else if (count1 == 0) {
                cand1 = arr[i];
                count1 = 1;
            } else if (arr[i] == cand2)
                ++count2;
            else if (count2 == 0) {
                cand2 = arr[i];
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == cand1)
                ++count1;
            else if (arr[i] == cand2)
                ++count2;
        }

        if (count1 > n / 3)
            return cand1;
        else if (count2 > n / 3)
            return cand2;
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 1 };
        System.out.println(moreThanNBy3(arr));
    }
}
