// https://www.geeksforgeeks.org/reverse-words-in-a-given-string/

public class Solution {
    // TC: O(n), SC: O(1)
    public static void reverseWords(String str) {
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int j = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == ' ') {
                reverse(arr, j, i - 1);
                j = i + 1;
            }
        }
        reverse(arr, j, arr.length - 1);

        for (char c : arr)
            System.out.print(c);
    }

    public static void reverse(char[] arr, int low, int high) {
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            ++low;
            --high;
        }
    }

    public static void main(String[] args) {
        String str = "Welcome to IIT Guwahati";
        reverseWords(str);
    }
}
