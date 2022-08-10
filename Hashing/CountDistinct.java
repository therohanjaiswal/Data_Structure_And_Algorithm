
// https://www.geeksforgeeks.org/count-distinct-elements-in-an-array/
import java.util.HashSet;

class CountDistinct {
    // TC: O(n^2), SC: O(1)
    public static int countDistinctNaive(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ++result;
        }
        return result;
    }

    // TC: O(n), SC: O((distinct n))
    public static int countDistinctEfficient(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i)
            if (!set.contains(arr[i]))
                set.add(arr[i]);
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 20, 30 };
        System.out.println(countDistinctNaive(arr));
        System.out.println(countDistinctEfficient(arr));
    }
}
