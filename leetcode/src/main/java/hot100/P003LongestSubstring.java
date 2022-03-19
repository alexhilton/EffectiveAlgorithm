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
}
