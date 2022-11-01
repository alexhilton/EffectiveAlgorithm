package daily;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P1662StringArrayEqualTest {
    private P1662StringArrayEqual instance;

    @BeforeEach
    public void setup() {
        instance = new P1662StringArrayEqual();
    }

    @Test
    public void testDemos() {
        assertTrue(instance.arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"}));
        assertFalse(instance.arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"ab", "c"}));
        assertTrue(instance.arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}));
    }

    @Test
    public void testCase106() {
        assertFalse(instance.arrayStringsAreEqual(new String[] {"abc","d","defg"}, new String[] {"abcddef"}));
    }
}
