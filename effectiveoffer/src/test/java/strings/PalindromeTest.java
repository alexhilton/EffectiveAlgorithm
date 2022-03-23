package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static strings.Palindrome.isPalindrome;
import static strings.Palindrome.validatePalindrome;

public class PalindromeTest {
    @Test
    public void testValidatePalindrome() {
        assertFalse(validatePalindrome(""));

        assertTrue(validatePalindrome("abca"));
    }

    @Test
    public void testCheckPalindrome() {
        assertFalse(isPalindrome(""));
        assertTrue(isPalindrome("a"));
        assertTrue(isPalindrome("     a"));
        assertTrue(isPalindrome("Was it a cat I saw?"));
        assertFalse(isPalindrome("race a car"));
    }
}
