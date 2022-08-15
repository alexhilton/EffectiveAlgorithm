package daily;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class P641CircularDequeTest {
    private P641CircularDeque.MyCircularDeque deque;

    @Test
    public void testDemo() {
        deque = new P641CircularDeque.MyCircularDeque(3);
        assertTrue(deque.insertLast(1));
        assertTrue(deque.insertLast(2));
        assertTrue(deque.insertFront(3));
        assertFalse(deque.insertFront(4));
        assertEquals(2, deque.getRear());
        assertTrue(deque.isFull());
        assertTrue(deque.deleteLast());
        assertTrue(deque.insertFront(4));
        assertEquals(4, deque.getFront());
    }
}
