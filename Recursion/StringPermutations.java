
// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
import java.util.*;

class Solution {
    public static void permute(String str, int low, int high, ArrayList<String> result) {
        if (low == high) {
            result.add(str);
            return;
        }

        for (int i = low; i <= high; ++i) {
            str = swap(str, low, i);
            permute(str, low + 1, high, result);
            str = swap(str, low, i);
        }
    }

    public static String swap(String str, int low, int high) {
        char[] arr = str.toCharArray();
        char temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        return String.valueOf(arr);

    }

    // Tc: O(n * n!), SC: O(1)
    public static ArrayList<String> permutations(String s) {
        ArrayList<String> result = new ArrayList<>();
        permute(s, 0, s.length() - 1, result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.print(permutations(str));
    }
}
