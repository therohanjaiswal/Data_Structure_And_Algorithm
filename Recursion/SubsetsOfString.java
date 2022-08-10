// https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
class Solution {
    public static void main(String[] args) {
        String str = "ABC";
        String curr = "";
        int index = 0;
        subsetsRecursive(str, curr, index);
    }

    // TC: O(2^n), SC: O(1)
    public static void subsetsRecursive(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        subsetsRecursive(s, curr, i + 1);
        subsetsRecursive(s, curr + s.charAt(i), i + 1);
    }
}
