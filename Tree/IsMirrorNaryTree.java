
// https://www.geeksforgeeks.org/check-mirror-n-ary-tree/
import java.util.*;

class Solution {
    public static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < 2 * e; i += 2) {
            if (!map.containsKey(A[i]))
                map.put(A[i], new Stack<>());
            else
                map.get(A[i]).push(A[i + 1]);
        }

        for (int i = 0; i < 2 * e; i += 2) {
            if (map.containsKey(B[i]) && map.get(B[i]).size() > 0) {
                if (map.get(B[i]).peek() != B[i + 1])
                    return 0;
                map.get(B[i]).pop();
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        // n = max no of child nodes, e = total edges
        int n = 3, e = 2;
        int[] A = { 1, 2, 1, 3 };
        int[] B = { 1, 3, 1, 2 };
        System.out.print(checkMirrorTree(n, e, A, B));
    }
}
