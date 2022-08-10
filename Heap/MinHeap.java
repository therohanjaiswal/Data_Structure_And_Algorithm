class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    MinHeap(int capacity) {
        heap = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    // TC: O(logn), SC: O(1)
    public int extractMin() {
        if (size == 0)
            return Integer.MAX_VALUE;
        swap(0, size - 1);
        --size;
        minHeapify(0);
        return heap[size];
    }

    // This function corrects the value at index i
    // to satisfy min heap property
    // TC: O(logn), SC: O(1)
    public void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        // finding the min among (i, left child, right child)
        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        // if i itself is the smallest, no need to swap
        // if i is not the smallest, then swap
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public void insert(int x) {
        if (size == capacity)
            return;
        ++size;
        int i = size - 1;
        heap[i] = x;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public void decreaseKey(int i, int newVal) {
        if (i >= size)
            return;

        heap[i] = newVal;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.insert(7);
        minHeap.insert(20);
        minHeap.insert(11);
        minHeap.insert(15);
        minHeap.insert(3);
    }
}
