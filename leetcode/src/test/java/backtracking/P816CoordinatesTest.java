package backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P816CoordinatesTest {
    private P816Coordinates instance;

    @BeforeEach
    public void setup() {
        instance = new P816Coordinates();
    }

    @Test
    public void testDemos() {
        System.out.println("123 -> " + instance.ambiguousCoordinates("(123)"));
        System.out.println("000011 -> " + instance.ambiguousCoordinates("(00011)"));
        System.out.println("0123 -> " + instance.ambiguousCoordinates("(0123)"));
        System.out.println("100 -> " + instance.ambiguousCoordinates("(100)"));
    }
}
