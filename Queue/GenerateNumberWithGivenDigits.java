import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void printFirstN(int N) {
        // here, given digits are 5 and 6
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(6);
        for (int i = 0; i < N; ++i) {
            int x = q.remove();
            System.out.println(x);
            q.add(x * 10 + 5);
            q.add(x * 10 + 6);
        }
    }

    public static void main(String[] args) {
        int N = 10;
        printFirstN(N);
    }
}
