package numbers;

import org.junit.jupiter.api.Test;

import static numbers.Binaries.countBits;
import static numbers.Binaries.stringAddition;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTest {
    @Test
    public void testAddBasics() {
        assertEquals("101", stringAddition("11", "10"));
        assertEquals("1", stringAddition("1", "0"));

        assertEquals("1001", stringAddition("1000", "1"));
        assertEquals("10000", stringAddition("1111", "1"));
        assertEquals("11110", stringAddition("1111", "1111"));
    }

    @Test
    public void testAddBoundaries() {
        assertEquals("0", stringAddition("0", "0"));

        assertEquals("10000000000000", stringAddition("1111111111111", "1"));
        assertEquals("10000000000001", stringAddition("10000000000000", "1"));
    }

    @Test
    public void testCountBits() {
        assertArrayEquals(new int[]{0}, countBits(0));
        assertArrayEquals(new int[]{0, 1}, countBits(1));
        assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2}, countBits(3));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1}, countBits(4));
    }
}
