package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P775IdealPermTest {
    private P775IdealPerm instance;

    @BeforeEach
    public void setup() {
        instance = new P775IdealPerm();
    }

    @Test
    public void testDemos() {
        assertTrue(instance.isIdealPermutation(new int[] {1, 0, 2}));
        assertFalse(instance.isIdealPermutation(new int[] {1, 2, 0}));
    }

    @Test
    public void testCase168() {
        assertFalse(instance.isIdealPermutation(new int[] {2, 0, 1}));
    }
}
