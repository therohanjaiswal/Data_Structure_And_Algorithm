class Solution {
    // TC: O(n)
    public static boolean isPalindrome(String str, int low, int high) {
        if (high >= low)
            return true;
        if (str.charAt(low) != str.charAt(high))
            return false;
        return isPalindrome(str, low + 1, high - 1);
    }

    public static void main(String[] args) {
        String str = "malayalam";
        if (isPalindrome(str, 0, str.length() - 1))
            System.out.println(str + " is a palindrome.");
        else
            System.out.println(str + " is not a palindrome.");
    }
}
