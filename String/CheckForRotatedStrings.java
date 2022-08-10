// https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
class Solution {
    // TC: O(n), SC: O(1)
    public static boolean areRotations(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        return (str1 + str1).indexOf(str2) >= 0;
    }

    public static void main(String[] args) {
        String str1 = "abab";
        String str2 = "aabb";
        System.out.println(areRotations(str1, str2));
    }
}
