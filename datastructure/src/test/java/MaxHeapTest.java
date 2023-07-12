import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxHeapTest {
    @Test
    public void testBasics() {
        MaxHeap inst = new MaxHeap(5);
        assertTrue(inst.isEmpty(), "New instance is empty");

        inst.offer(4);
        assertEquals(4, inst.poll(), "One element");
    }
}
