package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P049GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (String item : strs) {
            for (List<String> subList : result) {

            }
        }
        return result;
    }

    private static byte[] strMap(String str) {
        byte[] map = new byte[26];
        for (char ch : str.toCharArray()) {
            map[ch - 'a']++;
        }

        return map;
    }
}
