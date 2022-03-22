package strings;

// Section 2 of Chap 03
// Use double pointer to solve string questions.
public class DoublePointer {
    // Question 14
    // Bruteforce version.
    // O(m*n*26)
    public static boolean checkInclusionBruteforce(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        byte[] map = new byte[26];
        for (char ch : s1.toCharArray()) {
            map[ch - 'a'] += 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            int limit = Math.min(i + s1.length(), s2.length());
            for (int j = i; j < limit; j++) {
                int idx = s2.charAt(j) - 'a';
                if (map[idx] > 0) {
                    map[idx] -= 1;
                }
            }
            boolean match = false;
            for (int k = 0; k < 26; k++) {
                match = true;
                if (map[k] != 0) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
