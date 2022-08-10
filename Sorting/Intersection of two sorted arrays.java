// {https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
// TC: O(n), SC: O(1)

class Solution {
    public static void findIntersection(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0;

        while (i < n && j < m) {
            // to handle duplicates
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }

            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 20, 20, 40, 60 };
        int[] arr2 = { 10, 20, 20, 20, 60, 60 };
        int n = arr1.length;
        int m = arr2.length;
        findIntersection(arr1, arr2, n, m);
    }
}
