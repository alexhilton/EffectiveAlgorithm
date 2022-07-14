package daily;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P745WordFilterTest {
    @Test
    public void testBasics() {
        P745WordFilter wf = new P745WordFilter(new String[] {"apple"});
        assertEquals(-1, wf.f("e", "e"));
        assertEquals(0, wf.f("a", "e"));
    }

    @Test
    public void TestMore() {
        P745WordFilter wf = new P745WordFilter(new String[] {"abbba","abba"});
        assertEquals(1, wf.f("ab", "ba"));
    }
}
