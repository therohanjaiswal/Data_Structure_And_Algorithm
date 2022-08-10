class Queue {
    int size, cap;
    int[] arr;

    Queue(int c) {
        arr = new int[c];
        cap = c;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == cap;
    }

    void enqueue(int val) {
        if (isFull())
            return;
        arr[size++] = val;
    }

    void dequeue() {
        if (isEmpty())
            return;
        for (int i = 0; i < size - 1; ++i)
            arr[i] = arr[i + 1];
        size--;
    }

    int getFront() {
        if (isEmpty())
            return -1;
        return arr[0];
    }

    int getRear() {
        if (isEmpty())
            return -1;
        return arr[size - 1];
    }
}
