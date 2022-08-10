public class Solution {
    public static void printSubsequences(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        printSubsequences(str.substring(1), ans + str.charAt(0));
        printSubsequences(str.substring(1), ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences(str, "");
    }
}
