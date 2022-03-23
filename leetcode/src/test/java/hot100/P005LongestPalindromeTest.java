package hot100;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P005LongestPalindromeTest {
    private static Function<String, String> action;

    @BeforeAll
    public static void setup() {
        action = P005LongestPalindrome::indexAsCenter;
    }

    @Test
    public void testBasics() {
        assertEquals("", action.apply(""));

        assertEquals("a", action.apply("a"));
        assertEquals("a", action.apply("ab"));
        assertEquals("aa", action.apply("aa"));
        assertEquals("aa", action.apply("aab"));
    }

    @Test
    public void testMore() {
        assertEquals("bab", action.apply("babad"));
        assertEquals("bb", action.apply("cbbd"));
    }
}
