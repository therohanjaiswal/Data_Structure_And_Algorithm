
// https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
import java.util.HashSet;

// elements can repeat
class Solution {
    // TC: O(n*(m + n)), SC: O(1)
    public static int findUniqueIntersectingElementsNaive(int[] arr1, int[] arr2) {
        int result = 0;
        for (int i = 0; i < arr1.length; ++i) {
            // checks if the element has appeaered before
            boolean flag = false;
            for (int j = 0; j < i; ++j) {
                if (arr1[i] == arr1[j]) {
                    flag = true;
                    break;
                }
            }

            if (flag)
                continue;

            for (int j = 0; j < arr2.length; ++j) {
                if (arr1[i] == arr2[j]) {
                    ++result;
                    break;
                }
            }
        }
        return result;
    }

    // TC: O(n+m), SC: O(n)
    public static int findUniqueIntersectingElementsEfficient(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; ++i)
            set.add(arr1[i]);

        int result = 0;
        for (int i = 0; i < arr2.length; ++i) {
            if (set.contains(arr2[i])) {
                ++result;
                set.remove((Integer) arr2[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 10, 30, 20 };
        int[] arr2 = { 20, 10, 10, 40 };
        int result = findUniqueIntersectingElementsNaive(arr1, arr2);
        System.out.println("Number of unique intersecting elements: " + result);
        result = findUniqueIntersectingElementsEfficient(arr1, arr2);
        System.out.println("Number of unique intersecting elements: " + result);
    }
}
