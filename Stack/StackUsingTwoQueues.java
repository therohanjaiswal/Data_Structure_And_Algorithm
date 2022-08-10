// https://www.geeksforgeeks.org/implement-stack-using-queue/
// making pop operation costly
class StackUsingTwoQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsingTwoQueues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    // Function to push an element into stack using two queues.
    public void push(int a) {
        q1.add(a);
    }

    // Function to pop an element from stack using two queues.
    public int pop() {
        if (isEmpty())
            return -1;
        while (q1.size() != 1)
            q2.add(q1.remove());
        int x = q1.remove();
        while (!q2.isEmpty())
            q1.add(q2.remove());
        return x;
    }

    public int top() {
        if (isEmpty())
            return -1;
        while (q1.size() != 1)
            q2.add(q1.remove());
        int x = q1.remove();
        while (!q2.isEmpty())
            q1.add(q2.remove());
        q1.add(x);
        return x;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
