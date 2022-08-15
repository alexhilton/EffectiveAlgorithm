package daily;

public class P641CircularDeque {
    static class MyCircularDeque {
        private final int capacity;
        private final int[] deque;
        private int front;
        private int rear;

        public MyCircularDeque(int k) {
            capacity = k;
            deque = new int[k];
            front = -1;
            rear = -1;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                front = rear = capacity / 2;
                deque[front] = value;
                return true;
            }
            front--;
            if (front < 0) {
                front += capacity;
            }
            deque[front] = value;
            dump("insert front after ");
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                front = rear = capacity / 2;
                deque[front] = value;
                return true;
            }
            rear++;
            if (rear >= capacity) {
                rear -= capacity;
            }
            deque[rear] = value;
            dump("insert last after ");
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            if (size() == 1) {
                front = -1;
                rear = -1;
            } else {
                front++;
                if (front >= capacity) {
                    front -= capacity;
                }
            }
            dump("delete front ");
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            if (size() == 1) {
                front = -1;
                rear = -1;
            } else {
                rear--;
                if (rear < 0) {
                    rear += capacity;
                }
            }
            dump("delete last ");
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque[rear];
        }

        public boolean isEmpty() {
            dump("isemtpy ");
            return size() == 0;
        }

        public boolean isFull() {
            dump("isFull ");
            return size() == capacity;
        }

        private int size() {
            if (front < 0 || rear < 0) {
                return 0;
            }
            if (rear >= front) {
                return rear - front + 1;
            } else {
                return capacity - front + rear;
            }
        }

        private void dump(String msg) {
            System.out.println(msg + ", front " + front + ", rear " + rear + ", size " + size() + ", capacity " + capacity);
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
