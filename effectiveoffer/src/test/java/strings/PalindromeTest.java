package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static strings.Palindrome.*;

public class PalindromeTest {
    @Test
    public void testCountSubPalindrome() {
        assertEquals(0, countSubPalindrome(""));
        assertEquals(3, countSubPalindrome("abc"));
        assertEquals(6, countSubPalindrome("aaa"));
    }

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
