// https://www.geeksforgeeks.org/queue-using-stacks/
// Here, remove() is heavy
class QueueUsingTwoStack {
    Stack<Integer> st1, st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void enqueue(int x) {
        st1.push(x);
    }

    public int remove() {
        if (isEmpty())
            return -1;
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.pop();
    }

    public int peek() {
        if (isEmpty())
            return -1;
        if (st2.isEmpty()) {
            while (!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.peek();
    }

    public boolean isEmpty() {
        if (st1.isEmpty() && st2.isEmpty())
            return true;
        return false;
    }
}
