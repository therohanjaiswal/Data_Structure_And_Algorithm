import java.util.Stack;

// TC: Push: O(1), Pop: O(1), getMin: O(1), SC: O(n)
class SpecialStack extends Stack<Integer> {
    // stack which stores elements in decreasing order,
    // where stack top element is always the minimum element
    Stack<Integer> minStack = new Stack<>();

    void push(int val) {
        if (isEmpty()) {
            super.push(val);
            minStack.push(val);
            return;
        }

        // if new minimum elements comes,
        // then push it into minStack
        if (val < minStack.peek())
            minStack.push(val);

        // super stack pushes all the elements
        // it acts like standard stack
        super.push(val);
    }

    public Integer pop() {
        if (isEmpty())
            return -1;

        int x = super.pop();
        if (x == minStack.peek())
            minStack.pop();
        return x;
    }

    int getMin() {
        if (isEmpty())
            return -1;

        return minStack.peek();
    }
}
