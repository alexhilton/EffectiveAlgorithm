import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {
    @Test
    public void testBasics() {
        MaxHeap inst = new MaxHeap(5);
        assertTrue(inst.isEmpty(), "New instance is empty");

        inst.offer(4);
        assertEquals(4, inst.peek(), "One element");
        assertFalse(inst.isEmpty(), "Peek not deleted");
        assertEquals(4, inst.poll(), "One element");
        assertTrue(inst.isEmpty(), "After poll only element, should empty");
    }

    @Test
    public void testNormal() {
        MaxHeap inst = new MaxHeap(10);
        inst.offer(3);
        inst.offer(10);
        inst.offer(12);
        inst.offer(8);
        inst.offer(2);
        inst.offer(14);
        assertEquals(6, inst.heapSize());
        assertEquals(14, inst.poll());
        assertEquals(12, inst.poll());
        assertEquals(10, inst.poll());
        assertEquals(3, inst.heapSize());
        inst.offer(20);
        inst.offer(4);
        inst.offer(12);
        assertEquals(6, inst.heapSize());
        assertEquals(20, inst.poll());
        assertEquals(12, inst.peek());
        assertEquals(12, inst.poll());
        assertEquals(4, inst.heapSize());
    }
}
