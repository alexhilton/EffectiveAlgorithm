package algo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P224CalculatorTest {
    private P224Calculator instance;

    @BeforeEach
    public void setup() {
        instance = new P224Calculator();
    }

    @Test
    public void testDemos() {
        assertEquals(2, instance.calculate("1 + 1"));
        assertEquals(3, instance.calculate(" 2-1 + 2 "));
        assertEquals(23, instance.calculate("(1+(4+5+2)-3)+(6+8)"));
        assertEquals(-1, instance.calculate("-1"));
        assertEquals(-4, instance.calculate("-(1+3)"));
        assertEquals(2, instance.calculate("1+(2+(3-4))"));
        assertEquals(29, instance.calculate("(1+(4+5+2)+3)+(6+8)"));
        assertEquals(2, instance.calculate("1-(-(-(-4+3-3+6) + 1)-4+2)"));

        assertEquals(-1, instance.calculate("- 2 + 1"));
    }
}
