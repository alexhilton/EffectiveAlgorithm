package hash;

import java.util.*;

public class MoreHashing {
    // Question 35
    public int findMinDiff(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean[] minuteFlags = new boolean[1440];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (minuteFlags[min]) {
                return 0;
            }

            minuteFlags[min] = true;
        }

        return calcDiff(minuteFlags);
    }

    private int calcDiff(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for (int i = 0; i < minuteFlags.length; i++) {
            if (minuteFlags[i]) {
                if (prev > 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }

                prev = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }

        minDiff = Math.min(first + minuteFlags.length - last, minDiff);
        return minDiff;
    }

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
