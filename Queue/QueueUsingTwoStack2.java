// https://www.geeksforgeeks.org/queue-using-stacks/
// Here, enqueue() is heavy
class QueueUsingTwoStack2 {
    Stack<Integer> st1, st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void enqueue(int x) {
        while (!st1.isEmpty())
            st2.push(st1.pop());
        st1.push(x);
        while (!st2.isEmpty())
            st1.push(st2.pop());
    }

    public int remove() {
        if (isEmpty())
            return -1;
        return st1.pop();
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return st1.peek();
    }

    public boolean isEmpty() {
        if (st1.isEmpty())
            return true;
        return false;
    }
}
