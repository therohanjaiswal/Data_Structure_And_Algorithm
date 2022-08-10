import java.util.Queue;

// https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/
class StackUsingOneQueue {
    Queue<Integer> q;

    StackUsingOneQueue() {
        q = new Queue<>();
    }

    public void push(int val) {
        int size = q.size();
        q.add(val);
        for (int i = 0; i < size; ++i)
            q.add(q.remove());
    }

    public int pop() {
        if (isEmpty())
            return -1;
        return q.remove();
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
