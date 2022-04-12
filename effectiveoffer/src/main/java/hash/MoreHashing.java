package hash;

import java.util.*;

public class MoreHashing {
    // Question 34
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderArray)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSorted(String a, String b, int[] order) {
        int i = 0;
        for (; i < a.length() && i < b.length(); i++) {
            char cha = a.charAt(i);
            char chb = b.charAt(i);
            if (order[cha - 'a'] < order[chb - 'a']) {
                return true;
            }

            if (order[cha - 'a'] > order[chb - 'a']) {
                return false;
            }
        }

        return i == a.length();
    }

    // Question 33
    // Use sorted string as the key, anagrams has the same sorted key.
    public List<List<String>> groupAnagramsAgain(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            groups.putIfAbsent(sorted, new LinkedList<>());
            groups.get(sorted).add(str);
        }

        return new LinkedList<>(groups.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] hash = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        };

        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long wordHash = 1;
            for (int i = 0; i < str.length(); i++) {
                wordHash *= hash[str.charAt(i) - 'a'];
            }

            groups.putIfAbsent(wordHash, new ArrayList<>());
            groups.get(wordHash).add(str);
        }

        return new LinkedList<>(groups.values());
    }
}
