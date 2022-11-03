package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P1668MaxRepeatingTest {
    private P1668MaxRepeating instance;

    @BeforeEach
    public void setup() {
        instance = new P1668MaxRepeating();
    }

    @Test
    public void testDemos() {
        assertEquals(2, instance.maxRepeating("ababc", "ab"));
        assertEquals(1, instance.maxRepeating( "ababc", "ba"));
        assertEquals(0, instance.maxRepeating("ababc", "ac"));
    }

    @Test
    public void testCase12() {
        assertEquals(5, instance.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
