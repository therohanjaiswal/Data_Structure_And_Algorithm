
// Design a data structure that supports following peration in O(1) time complexity
// 1. insertMin(x)
// 2. insertMax(x)
// 3. getMin()
// 4. getMax()
// 5. extractMin()
// 6. extractMax() 
import java.util.*;

class MyDS {
    Deque<Integer> d;

    MyDS() {
        d = new LinkedList<>();
    }

    void insertMin(int val) {
        d.addFirst(val);
    }

    void insertMax(int val) {
        d.addLast(val);
    }

    int getMin() {
        return d.peekFirst();
    }

    int getMax() {
        return d.peekLast();
    }

    int extractMin() {
        return d.removeFirst();
    }

    int extractMax() {
        return d.removeLast();
    }
}
