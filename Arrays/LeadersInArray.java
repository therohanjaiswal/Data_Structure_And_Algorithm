//  https://www.geeksforgeeks.org/leaders-in-an-array/
import java.util.ArrayList;

class Solution {
    // TC: O(n), SC: O(1)
    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        int max = arr[n - 1];
        leaders.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 10, 6, 5, 2 };
        ArrayList<Integer> result = findLeaders(arr);
        for (Integer a : result) {
            System.out.println(a);
        }
    }
}
