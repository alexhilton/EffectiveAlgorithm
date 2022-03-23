package strings;

public class Palindrome {
    // Question 20
    public static int countSubPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += doCountSubPalindrome(s, i, i);
            count += doCountSubPalindrome(s, i, i + 1);
        }
        return count;
    }

    private static int doCountSubPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }

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
