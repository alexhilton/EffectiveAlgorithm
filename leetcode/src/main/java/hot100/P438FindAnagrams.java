package hot100;

import java.util.ArrayList;
import java.util.List;

public class P438FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s.length() < p.length()) {
            return result;
        }

        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }
        if (allZero(map)) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            map[s.charAt(i) - 'a']--;
            map[s.charAt(i - p.length()) - 'a']++;
            if (allZero(map)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private static boolean allZero(int[] counts) {
        for (int c : counts) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}
