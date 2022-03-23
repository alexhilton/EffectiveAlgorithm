package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static strings.Palindrome.isPalindrome;

public class PalindromeTest {
    @Test
    public void testCheckPalindrome() {
        assertFalse(isPalindrome(""));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("     a"));
        assertTrue(isPalindrome("Was it a cat I saw?"));
        assertFalse(isPalindrome("race a car"));
    }
}
