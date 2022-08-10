// https://www.geeksforgeeks.org/array-implementation-of-queue-simple/
class Queue {
    Node front, rear;
    int size;

    Queue() {
        front = rear = null;
        size = 0;
    }

    void enqueue(int val) {
        Node newNode = new Node(val);
        ++size;
        if (front == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    void dequeue() {
        if (front == null)
            return;
        --size;
        if (front == rear) {
            front = null;
            rear = null;
            return;
        }
        front = front.next;
    }

    int getSize() {
        return size;
    }
}

class Node {
    int data;
    Node next;

    Node(int mData) {
        data = mData;
        next = null;
    }
}
