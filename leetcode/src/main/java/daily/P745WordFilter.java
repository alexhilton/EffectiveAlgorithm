package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P745WordFilter {
    private TrieNode prefixRoot;
    private TrieNode suffixRoot;
    private Map<String, Integer> wordToIndex;

    public P745WordFilter(String[] words) {
        prefixRoot = new TrieNode();
        suffixRoot = new TrieNode();
        wordToIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            buildTrie(prefixRoot, words[i], true);
            buildTrie(suffixRoot, words[i], false);
            wordToIndex.put(words[i], i);
        }
    }

    private void buildTrie(TrieNode root, String w, boolean prefix) {
        TrieNode node = root;
        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(prefix ? i : w.length() - i - 1);
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    public int f(String pref, String suff) {
        TrieNode prefixNode = startsWith(prefixRoot, pref, true);
        Set<String> prefixSet = new HashSet<>();
        dfs(prefixNode, prefixSet, new StringBuilder(pref), true);
        prefixSet.forEach(System.out::println);

        System.out.println("see suffix set ");
        TrieNode suffixNode = startsWith(suffixRoot, suff, false);
        Set<String> suffixSet = new HashSet<>();
        dfs(suffixNode, suffixSet, new StringBuilder(suff).reverse(), false);
        suffixSet.forEach(System.out::println);

        return prefixSet.stream()
                .filter(w -> suffixSet.contains(w))
                .map(w -> wordToIndex.get(w))
                .mapToInt(Integer::intValue)
                .max()
                .orElse(-1);
    }

    private void dfs(TrieNode root, Set<String> set, StringBuilder sb, boolean prefix) {
        if (root == null) {
            return;
        }
        TrieNode node = root;
        if (node.isWord) {
            set.add(prefix ? sb.toString() : sb.reverse().toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sb.append((char) (i + 'a'));
                dfs(node.children[i], set, new StringBuilder(sb), prefix);
            }
        }
    }

    private TrieNode startsWith(TrieNode root, String pref, boolean prefix) {
        TrieNode node = root;
        for (int i = 0; i < pref.length(); i++) {
            char ch = pref.charAt(prefix ? i : pref.length() - i - 1);
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }

        return node;
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
}
