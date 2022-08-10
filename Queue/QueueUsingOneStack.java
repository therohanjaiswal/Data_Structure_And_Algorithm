import java.util.*;

class QueueUsingOneStack {
    Stack<Integer> st;

    QueueUsingOneStack() {
        st = new Stack<>();
    }

    void enqueue(int val) {
        st.push(val);
    }

    int remove() {
        if (isEmpty())
            return -1;
        int e = st.pop();
        int res = remove();
        if (res == -1)
            return e;
        else {
            st.push(e);
            return res;
        }
    }

    boolean isEmpty() {
        return st.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingOneStack q = new QueueUsingOneStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
