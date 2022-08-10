
// https://www.geeksforgeeks.org/reversing-queue-using-recursion/
import java.util.*;

// https://www.geeksforgeeks.org/reversing-queue-using-recursion/
class Solution {
    // TC:(n), SC:O(n)
    public static Queue<Integer> reverseQueueIterative(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty())
            st.push(q.remove());

        while (!st.isEmpty())
            q.add(st.pop());

        return q;
    }

    // TC:(n), SC:O(1)
    public static Queue<Integer> reverseQueueRecursive(Queue<Integer> q) {
        if (q.isEmpty())
            return q;

        int e = q.remove();
        reverseQueueRecursive(q);
        q.add(e);
        return q;
    }

    public static void printQueue(Queue<Integer> q) {
        while (!q.isEmpty())
            System.out.println(q.remove());
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);
        q.add(6);
        q = reverseQueueIterative(q);
        q = reverseQueueRecursive(q);
        printQueue(q);
    }
}
