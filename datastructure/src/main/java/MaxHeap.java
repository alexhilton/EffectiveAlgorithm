import java.net.CacheRequest;

public class MaxHeap {
    private final int capacity;
    private int size;
    private final int[] elements;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        elements = new int[capacity];
    }

    public void offer(int e) {
        //
    }

    public int peek() {
        return -1;
    }

    public int poll() {
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
