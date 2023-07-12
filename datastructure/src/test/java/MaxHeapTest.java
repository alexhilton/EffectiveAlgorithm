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
}
