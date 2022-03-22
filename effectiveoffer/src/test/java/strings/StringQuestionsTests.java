package strings;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringQuestionsTests {
    @Test
    public void testCheckInclusion() {
        BiFunction<String, String, Boolean> action = DoublePointer::checkInclusion;

        assertFalse(action.apply("abcdef", "abcd"));

        assertTrue(action.apply("ac", "dgcaf"));
        assertFalse(action.apply("ab", "dgcaf"));
    }
}
