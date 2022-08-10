import java.util.*;;

class Solution {
    // TC: O(2^|S|), SC: O(1)
    public static ArrayList<String> removeInvalidParentheses(String s) {
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;
        q.add(s);
        visited.add(s);

        while (!q.isEmpty()) {
            String curr = q.remove();
            if (isValidString(curr)) {
                res.add(curr);
                level = true;
            }
            // this flag is given such that once valid string of a length l is found,
            // we don't take valid substrings of length < l of those string
            // once a valid string is found, it means we have got length l valid
            // string. So we don't need to check substrings of valid and invalid strings.
            if (level)
                continue;

            for (int i = 0; i < curr.length(); ++i) {
                if (isParenthesis(curr.charAt(i))) {
                    temp = curr.substring(0, i) + curr.substring(i + 1);
                    if (!visited.contains(temp)) {
                        q.add(temp);
                        visited.add(temp);
                    }
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    public static boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }

    public static boolean isValidString(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(')
                ++count;
            else if (c == ')')
                --count;
            if (count < 0)
                return false;
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String str = "()())()";
        ArrayList<String> res = removeInvalidParentheses(str);
        System.out.println(res);
    }
}