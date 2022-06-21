package hot100;

import org.junit.jupiter.api.Test;

import static hot100.P152MaxProduct.maxProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P152MaxProductTest {
    @Test
    public void demos() {
        assertEquals(6, maxProduct(new int[] {2, 3, -2, 4}));
        assertEquals(0, maxProduct(new int[] {-2, 0, -1}));
    }

    @Test
    public void boundaries() {
        assertEquals(1, maxProduct(new int[] {1}));
        assertEquals(1, maxProduct(new int[] {1, 0}));
        assertEquals(0, maxProduct(new int[] {0, -1}));
        assertEquals(1, maxProduct(new int[] {1, 1, 1}));
        assertEquals(1, maxProduct(new int[] {-1, 1, -1}));
    }

    @Test
    public void testSuite() {
        assertEquals(24, maxProduct(new int[] {-2, 3, -4}));
        assertEquals(24, maxProduct(new int[] {2, -5, -2, -4, 3}));
        assertEquals(720, maxProduct(new int[] {1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void testFinally() {
        assertEquals(720, maxProduct(new int[] {-1, 2, 3, 4, -5}));
        assertEquals(720, maxProduct(new int[] {-1, -2, 3, 4, -5}));
        assertEquals(1280, maxProduct(new int[] {1,2,-1,-2,2,1,-2,1,4,-5,4}));
    }
}
