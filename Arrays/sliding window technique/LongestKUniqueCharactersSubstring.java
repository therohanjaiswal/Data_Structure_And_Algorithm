
// https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(k)
    public static int longestKSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int largest = -1;
        int start = 0;

        for (int end = 0; end < s.length(); ++end) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == k) {
                largest = Math.max(largest, end - start + 1);
            } else if (map.size() > k) {
                while (map.size() > k && start < end - 1) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0)
                        map.remove(s.charAt(start));
                    start++;
                }
                if (map.size() == k)
                    largest = Math.max(largest, end - start + 1);

            }
        }

        return largest;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(str, k));
    }
}