import java.net.CacheRequest;

public class MaxHeap {
    private static final int INF = Integer.MAX_VALUE;

    private final int capacity;
    private int size;
    private final int[] elements;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        elements = new int[capacity];
    }

    public void offer(int e) {
        if (size == capacity) {
            // Overflowed.
            return;
        }
        size++;
        int i = size - 1;
        elements[i] = e;

        while (i != 0 && elements[parent(i)] < elements[i]) {
            swap(i, parent(i));
        }
    }

    public int peek() {
        return elements[0];
    }

    public int poll() {
        if (isEmpty()) {
            return INF;
        }
        if (size == 1) {
            size--;
            return elements[0];
        }

        int root = elements[0];
        elements[0] = elements[size - 1];
        size--;
        heapify(0);
        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < size && elements[l] > elements[i]) {
            largest = l;
        }
        if (r < size && elements[r] > elements[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int t = elements[i];
        elements[i] = elements[j];
        elements[j] = t;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i << 1) + 2;
    }
}
