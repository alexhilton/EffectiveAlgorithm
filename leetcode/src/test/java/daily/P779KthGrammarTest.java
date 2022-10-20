package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P779KthGrammarTest {
    private P779KthGrammar instance;

    @BeforeEach
    public void setup() {
        instance = new P779KthGrammar();
    }

    @Test
    public void testDemos() {
        assertEquals(0, instance.kthGrammar(1, 1));
        assertEquals(0, instance.kthGrammar(2, 1));
        assertEquals(1, instance.kthGrammar(2, 2));
    }

    @Test
    public void testBasics() {
        assertEquals(0, instance.kthGrammar(3, 1));
        assertEquals(1, instance.kthGrammar(3, 2));
        assertEquals(1, instance.kthGrammar(3, 3));
        assertEquals(0, instance.kthGrammar(3, 4));
    }

    @Test
    public void testMore() {
        assertEquals(0, instance.kthGrammar(4, 1));
        assertEquals(1, instance.kthGrammar(4, 2));

        assertEquals(1, instance.kthGrammar(4, 3));
        assertEquals(0, instance.kthGrammar(4, 4));

        assertEquals(1, instance.kthGrammar(4, 5));
        assertEquals(0, instance.kthGrammar(4, 6));

        assertEquals(0, instance.kthGrammar(4, 7));
        assertEquals(1, instance.kthGrammar(4, 8));
    }
}
