// https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/

class TwoStackInArray {
    int[] arr;
    int top1, top2, capacity;

    TwoStack(int cap) {
        arr = new int[cap];
        top1 = -1;
        top2 = arr.length;
        capacity = cap;
    }

    void push1(int data) {
        if (top2 - top1 == 1) {
            System.out.println("Overflow");
            return;
        }
        arr[++top1] = data;
    }

    int pop1() {
        if (top1 == -1) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top1--];
    }

    int peek1() {
        if (top1 == -1) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top1];
    }

    void push2(int data) {
        if (top2 - top1 == 1) {
            System.out.println("Overflow");
            return;
        }
        arr[--top2] = data;
    }

    int pop2() {
        if (top2 == cap) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top2++];
    }

    int peek2() {
        if (top2 == cap) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top2];
    }
}
