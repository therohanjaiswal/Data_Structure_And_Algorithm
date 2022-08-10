// https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
class CircularQueue {
    int[] arr;
    int cap, size, front;

    CircularQueue(int c) {
        arr = new int[c];
        cap = c;
        size = 0;
        front = -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == cap;
    }

    int getFront() {
        return front;
    }

    int getRear() {
        if (isEmpty())
            return -1;
        return (front + size - 1) % cap;
    }

    void enqueue(int val) {
        if (isFull())
            return;
        if (isEmpty())
            front = 0;
        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = val;
        ++size;
    }

    void dequeu() {
        if (isEmpty())
            return;
        front = (front + 1) % cap;
        --size;
    }
}
