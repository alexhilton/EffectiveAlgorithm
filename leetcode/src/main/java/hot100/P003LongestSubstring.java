package hot100;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class P003LongestSubstring {
    public static int bruteForce(String s) {
        int result = 0;
        if (s == null || s == "") {
            return result;
        }
        Map<Character, Character> substring = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            substring.clear();
            Character left = s.charAt(i);
            substring.put(left, left);
            int len = 1;
            for (int j = i + 1; j < s.length(); j++) {
                // [i, j] is the substring
                Character right = s.charAt(j);
                if (substring.containsKey(right)) {
                    break;
                } else {
                    len++;
                    substring.put(right, right);
                }
            }
            result = Math.max(result, len);
        }
        return result;
    }
}
