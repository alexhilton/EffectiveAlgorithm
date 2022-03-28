package hot100;

import java.util.ArrayList;
import java.util.List;

public class P049GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<byte[]> keys = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            byte[] currentKey = hash(strs[i]);
            List<String> group = null;
            for (int k = 0; k < keys.size(); k++) {
                if (matchKey(currentKey, keys.get(k))) {
                    group = result.get(k);
                    break;
                }
            }
            if (group == null) {
                keys.add(currentKey);
                group = new ArrayList<>();
                result.add(group);
            }
            group.add(strs[i]);
        }
        return result;
    }

    private static byte[] hash(String str) {
        byte[] map = new byte[26];
        for (char ch : str.toCharArray()) {
            map[ch - 'a']++;
        }

        return map;
    }

    private static boolean matchKey(byte[] key1, byte[] key2) {
        for (int i = 0; i < 26; i++) {
            if (key1[i] != key2[i]) {
                return false;
            }
        }

        return true;
    }
}
