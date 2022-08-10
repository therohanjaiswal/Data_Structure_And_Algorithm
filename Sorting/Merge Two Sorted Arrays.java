import java.util.ArrayList;

// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
class Solution {
    // TC: O(n+m), SC: O(n+m)
    // each array may contain duplicates
    public static ArrayList<Integer> mergeArrays(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (i < n && j < m) {
            // remove duplicates from arr1
            if (i > 0 && arr1[i - 1] == arr1[i]) {
                ++i;
                continue;
            }

            // remove duplicates from arr2
            if (j > 0 && arr2[j - 1] == arr2[j]) {
                ++j;
                continue;
            }

            if (arr1[i] < arr2[j])
                res.add(arr1[i++]);
            else
                res.add(arr2[j++]);
        }

        while (i < n) {
            if (i > 0 && arr1[i - 1] == arr1[i]) {
                ++i;
                continue;
            }
            res.add(arr1[i++]);
        }

        while (j < m) {
            if (j > 0 && arr2[j - 1] == arr2[j]) {
                ++j;
                continue;
            }
            res.add(arr2[j++]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 25, 25, 25, 46, 50 };
        int n = arr1.length;

        int[] arr2 = { 5, 34, 34, 70 };
        int m = arr2.length;

        System.out.println("Array before merging");
        for (int i : arr1)
            System.out.print(i + " ");

        for (int i : arr2) {
            System.out.print(i + " ");
        }

        ArrayList<Integer> res = mergeArrays(arr1, arr2, n, m);

        System.out.println();
        System.out.println("Array after merging");
        System.out.println(res);
    }
}
