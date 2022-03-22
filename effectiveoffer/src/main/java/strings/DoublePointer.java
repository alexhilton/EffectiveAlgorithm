package strings;

import java.util.ArrayList;
import java.util.List;

// Section 2 of Chap 03
// Use double pointer to solve string questions.
public class DoublePointer {
    // Question 16
    public static int maxUniqueSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int result = 0;
        byte[] substring = new byte[128];
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            substring[s.charAt(j)]++;
            while (i < j && substring[s.charAt(j)] != 1) {
                substring[s.charAt(i)]--;
                i++;
            }
            result = Math.max(j - i + 1, result);
        }

        return result;
    }

    // Question 15
    public static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> result = new ArrayList<>();
        if (s1.length() < s2.length()) {
            result.add(-1);
            return result;
        }
        int[] map = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            map[s2.charAt(i) - 'a']++;
            map[s1.charAt(i) - 'a']--;
        }
        if (allZero(map)) {
            result.add(0);
        }

        for (int i = s2.length(); i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']--;
            map[s1.charAt(i - s2.length()) - 'a']++;
            if (allZero(map)) {
                result.add(i - s2.length() + 1);
            }
        }
        return result;
    }

    // Question 14
    // double pointer, always remember to use right as anchor.
    // O(n*26)
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }

        if (allZero(map)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            map[s2.charAt(i) - 'a']--;
            map[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(map)) {
                return true;
            }
        }

        return false;
    }

    private static boolean allZero(int[] array) {
        for (int b : array) {
            if (b != 0) {
                return false;
            }
        }

        return true;
    }

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
