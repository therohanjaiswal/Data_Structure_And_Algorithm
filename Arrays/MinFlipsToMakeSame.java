// https://www.geeksforgeeks.org/minimum-group-flips-to-make-binary-array-elements-same/
class Solution {
    // One Group flip = fliping all continuous zeros or ones in one go.
    // Two traversals required
    // TC: O(n), SC: O(1)
    public static int getMinFlipsNaive(int[] arr) {
        // Traversal 1: FInd the number of groups of ones and zeros
        int countOfZerosGroups = 0, countOfOnesGroups = 0;
        int i;
        for (i = 1; i < arr.length; ++i) {
            if (arr[i] == 0 && arr[i] != arr[i - 1])
                ++countOfOnesGroups;
            if (arr[i] == 1 && arr[i] != arr[i - 1])
                ++countOfZerosGroups;
        }

        // to handle last element or group edge case
        if (arr[i - 1] == 0)
            ++countOfZerosGroups;

        // to handle last element or group edge case
        if (arr[i - 1] == 1)
            ++countOfOnesGroups;

        // Traversal 2: Find the digit which has minimum number of groups as we have to
        // then performs less flips
        int maxCountDigit = countOfOnesGroups > countOfZerosGroups ? 0 : 1;
        int start = -1, end = -1;
        for (i = 0; i < arr.length; ++i) {
            if (arr[i] == maxCountDigit) {
                if (start == -1)
                    start = i;
                end = i;
            } else {
                if (start != -1)
                    System.out.println(start + " " + end);
                start = -1;
                end = -1;
            }

        }
        if (start != -1)
            System.out.println(start + " " + end);

        return countOfOnesGroups > countOfZerosGroups ? countOfZerosGroups : countOfOnesGroups;
    }

    // The idea is that the difference between the countOfZerosGroups and
    // countOfOnesGroups will be always atmost 1. Take any arbitary array and
    // confirm. If the arr[0] == arr[n-1], then diff is 1 and if arr[0] != arr[n-1],
    // then diff is 0. We always flip the second group (the group of arr[1]th
    // element). If arr[1] == 1, then we will group flip 1 and if arr[1] = 0, then
    // we will flip 0.

    // One traversal required only
    // TC: O(n), SC: O(1)
    public static int getMinFlipsEfficient(int[] arr) {
        int n = arr.length;
        int minFlips = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else {
                    System.out.println(i - 1);
                    ++minFlips;
                }
            }
        }
        if (arr[n - 1] != arr[0])
            System.out.println(n - 1);
        return minFlips;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1 };
        int res = getMinFlipsNaive(arr);
        System.out.println("Min Flips: " + res);
    }
}
