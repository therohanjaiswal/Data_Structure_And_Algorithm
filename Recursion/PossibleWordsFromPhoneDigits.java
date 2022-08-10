// Expected Time Complexity: O(4N * N).
// Expected Auxiliary Space: O(N).

import java.util.*;

public class PossibleWordsFromPhoneDigits {
    public static void main(String[] args) {
        int[] a = { 2, 3, 4 };
        System.out.println(possibleWords(a, a.length));
    }

    public static ArrayList<String> possibleWords(int a[], int N) {
        // your code here
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return getList(a, 0, map);
    }

    public static ArrayList<String> getList(int[] arr, int i, HashMap<Integer, String> map) {
        if (i == arr.length) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        int ch = arr[i];
        // list of possible words with arr[3, 4]
        ArrayList<String> subList = getList(arr, ++i, map);
        ArrayList<String> myList = new ArrayList<>();
        String currCode = map.get(ch);
        for (int j = 0; j < currCode.length(); j++) {
            for (int k = 0; k < subList.size(); k++) {
                myList.add(currCode.charAt(j) + subList.get(k));
            }
        }
        return myList;
    }
}
