import java.util.Queue;

// https://www.geeksforgeeks.org/implement-stack-using-queue/
// making push operation costly
class StackUsingTwoQueues2 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsingTwoQueues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        while (!q1.isEmpty())
            q2.add(q1.remove());
        q1.add(x);
        while (!q2.isEmpty())
            q1.add(q2.remove());
    }

    public int pop() {
        if (q1.isEmpty())
            return -1;
        return q1.remove();
    }

    public int top() {
        if (empty())
            return -1;
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
