package numbers;

import org.junit.jupiter.api.Test;

import static numbers.Binaries.*;
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

    @Test
    public void testCountBits2() {
        assertArrayEquals(new int[]{0}, countBits2(0));
        assertArrayEquals(new int[]{0, 1}, countBits2(1));
        assertArrayEquals(new int[]{0, 1, 1}, countBits2(2));
        assertArrayEquals(new int[]{0, 1, 1, 2}, countBits2(3));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1}, countBits2(4));
    }

    @Test
    public void testCountBits3() {
        assertArrayEquals(new int[]{0}, countBits3(0));
        assertArrayEquals(new int[]{0, 1}, countBits3(1));
        assertArrayEquals(new int[]{0, 1, 1}, countBits3(2));
        assertArrayEquals(new int[]{0, 1, 1, 2}, countBits3(3));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1}, countBits3(4));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(0, singleNumber(new int[]{}));
        assertEquals(1, singleNumber(new int[]{1}));
        assertEquals(6, singleNumber(new int[]{1, 1, 1, 6}));
        assertEquals(100, singleNumber(new int[]{0, 1, 0, 1, 0, 1, 100}));
    }

    @Test
    public void testMaxProduct() {
        assertEquals(0, maxProduct(new String[]{}));
        assertEquals(0, maxProduct(new String[]{"ab", "bar", "aar", "far"}));
        assertEquals(25, maxProduct(new String[]{"abcde", "fghij"}));
        assertEquals(16, maxProduct(new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"}));
    }

    @Test
    public void testMaxProduct2() {
        assertEquals(0, maxProduct2(new String[]{}));
        assertEquals(0, maxProduct2(new String[]{"ab", "bar", "aar", "far"}));
        assertEquals(25, maxProduct2(new String[]{"abcde", "fghij"}));
        assertEquals(16, maxProduct2(new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"}));
    }
}
