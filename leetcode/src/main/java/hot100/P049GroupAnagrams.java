package hot100;

import java.util.ArrayList;
import java.util.List;

public class P049GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            byte[] current = strMap(strs[i]);
            List<String> group = null;
            for (List<String> subList : result) {
                if (match(current, strMap(subList.get(0)))) {
                    group = subList;
                    break;
                }
            }
            if (group == null) {
                group = new ArrayList<>();
                result.add(group);
            }
            group.add(strs[i]);
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

    private static boolean match(byte[] map1, byte[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }

        return true;
    }
}
