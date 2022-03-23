package strings;

public class Palindrome {
    // Question 19
    public static boolean validatePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() / 2) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left++;
            right--;
        }

        return left == s.length() / 2 || isSubPalindrome(s, left, right - 1) || isSubPalindrome(s, left + 1, right);
    }

    private static boolean isSubPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }

        return start >= end;
    }

    // Question 18
    // double pointer from both ends
    // ignore non digit and not letters
    // when pointer collide, stops.
    // The compare times of char is the same, so it can cover all digits and letters.
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char lch = s.charAt(i);
            char rch = s.charAt(j);
            if (!Character.isLetterOrDigit(lch)) {
                i++;
            } else if (!Character.isLetterOrDigit(rch)) {
                j--;
            } else {
                if (Character.toLowerCase(lch) != Character.toLowerCase(rch)) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }
}
