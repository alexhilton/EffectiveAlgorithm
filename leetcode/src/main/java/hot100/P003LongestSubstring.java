package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class P003LongestSubstring {
    public static int bruteForce(String s) {
        int result = 0;
        if (s == null || s == "") {
            return result;
        }
        Set<Character> substring = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            substring.clear();
            Character left = s.charAt(i);
            substring.add(left);
            int len = 1;
            for (int j = i + 1; j < s.length(); j++) {
                // [i, j] is the substring
                Character right = s.charAt(j);
                if (substring.contains(right)) {
                    break;
                } else {
                    len++;
                    substring.add(right);
                }
            }
            result = Math.max(result, len);
        }
        return result;
    }

    // Move the left according to the substring, and always move the right.
    // It should be faster than brute force, but not really.
    public static int doublePointer(String s) {
        int result = 0;
        if (s == null || s == "") {
            return result;
        }
        Map<Character, Integer> substring = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            substring.clear();
            substring.put(s.charAt(i), i);
            int len = 1;
            int j = i + 1;
            while (j < s.length()) {
                Character right = s.charAt(j);
                if (substring.containsKey(right)) {
                    break;
                }
                substring.put(right, j);
                len++;
                j++;
            }

            result = Math.max(result, len);

            if (j == s.length()) {
                // we are done
                break;
            }
            i = substring.get(s.charAt(j)) + 1;
        }
        return result;
    }

    // Fix the right pointer, which always move to next character.
    // Move the left when possible, which starts from 0,
    // kicking out repeating ch from map when moving left.
    // [left, right] contains the non-repeat substring always.
    // O(n+n) for the worst case.
    public static int doublePointerRight(String s) {
        int result = 0;
        if (s == null || s == "") {
            return result;
        }
        Map<Character, Integer> substring = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            Character right = s.charAt(j);
            substring.put(right, substring.getOrDefault(right, 0) + 1);
            while (i < j) {
                Character left = s.charAt(i);
                int leftCount = substring.get(left);
                int rightCount = substring.get(right);
                if (leftCount != 1 || rightCount != 1) {
                    i++;
                    substring.put(left, leftCount - 1);
                } else {
                    break;
                }
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    /*
     * Based on #doublePointerRight, with optimization of HashMap.
     * The string is a limited set of characters, which is ASCII, 128 at most.
     * Use a 128 byte array as the HashMap, index is the ch, value is its count.
     * The array holds non-repeat substring, so count is 2 at most, byte is very enough.
     * This can save a lot of time by avoiding autoboxing which is inevitable when using
     * HashMap.
     */
    public static int doublePointerRightArray(String s) {
        int result = 0;
        if (s == null || s == "") {
            return result;
        }
        byte[] substring = new byte[128];
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            substring[s.charAt(j)] += 1;
            while (i < j && (substring[s.charAt(i)] != 1 || substring[s.charAt(j)] != 1)) {
                substring[s.charAt(i)] -= 1;
                i++;
            }
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}
