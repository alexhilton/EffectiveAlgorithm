package hot100;

public class P005LongestPalindrome {
    // O(n^2)
    public static String indexAsCenter(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLength = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (maxLength < end - start - 1) {
                maxLength = end - start - 1;
                maxStart = start + 1;
                maxEnd = end - 1;
            }
            start = i;
            end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (maxLength < end - start - 1) {
                maxLength = end - start - 1;
                maxStart = start + 1;
                maxEnd = end - 1;
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }

    // Not AC.
    // Time limit exceeded.
    public static String bruteForce(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLength = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // [i, j] is the substring
                // save the indices if it is longest, so far.
                if (isPalindrome(s, i, j)) {
                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
