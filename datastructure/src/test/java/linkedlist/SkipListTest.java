package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkipListTest {
    private SkipList instance;

    @BeforeEach
    public void setup() {
        instance = new SkipList();
    }

    @Test
    public void testBasics() {
        assertFalse(instance.search(10), "Empty list not searchable.");
        assertFalse(instance.delete(20), "Cannot delete from empty list.");
        int n = 100;
        Random rand = new Random();
        int[] values = new int[7];
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(n);
            instance.insert(values[i]);
        }
        for (int i = 0; i < 3; i++) {
            int target = values[i * 2];
            assertTrue(instance.search(target), "Numbers inserted should be searched");
        }
        for (int i = 0; i < 3; i++) {
            int target = values[i * 2];
            assertTrue(instance.delete(target), "Numbers in the list can be deleted");
        }
        assertFalse(instance.delete(101), "Cannot delete numbers not in the list.");
    }
}
