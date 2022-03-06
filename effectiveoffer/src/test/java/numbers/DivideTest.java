package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static numbers.RawDivide.divide;

public class DivideTest {
    @Test
    public void testBasic() {
        assertEquals(0, divide(0, 1));
        assertEquals(0, divide(2, 3));
        assertEquals(2, divide(4, 2));
        assertEquals(3, divide(6, 2));
        assertEquals(4, divide(8, 2));
        assertEquals(4, divide(9, 2));
        assertEquals(7, divide(15, 2));
        assertEquals(2, divide(2, 1));
        assertEquals(500, divide(1000, 2));
        assertEquals(-512, divide(1024, -2));
    }

    @Test
    public void testPositives() {
        assertEquals(Integer.MAX_VALUE, divide(Integer.MAX_VALUE, 1));
        assertEquals(1, divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(0, divide(0, Integer.MAX_VALUE));
    }

    @Test
    public void testNegatives() {
        assertEquals(Integer.MIN_VALUE, divide(Integer.MIN_VALUE, 1));
        assertEquals(-Integer.MAX_VALUE, divide(Integer.MAX_VALUE, -1));
        assertEquals(0, divide(0, Integer.MIN_VALUE));
        assertEquals(1, divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(-1, divide(Integer.MAX_VALUE, -Integer.MAX_VALUE));
    }

    @Test
    public void testOverflows() {
        assertEquals(Integer.MAX_VALUE, divide(Integer.MIN_VALUE, -1));
    }
}