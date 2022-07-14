package daily;

import java.util.*;

public class P745WordFilter {
    private TrieNode prefixRoot;
    private TrieNode suffixRoot;

    public P745WordFilter(String[] words) {
        prefixRoot = new TrieNode();
        suffixRoot = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            buildTrie(prefixRoot, words[i], i, true);
            buildTrie(suffixRoot, words[i], i, false);
        }
    }

    private void buildTrie(TrieNode root, String w, int index, boolean prefix) {
        TrieNode node = root;
        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(prefix ? i : w.length() - i - 1);
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            node.indices.add(index);
        }
    }

    public int f(String pref, String suff) {
        TrieNode prefixNode = startsWith(prefixRoot, pref, true);
        if (prefixNode == null) {
            return -1;
        }

        TrieNode suffixNode = startsWith(suffixRoot, suff, false);
        if (suffixNode == null) {
            return -1;
        }

        List<Integer> preIndices = prefixNode.indices;
        List<Integer> suffIndices = suffixNode.indices;
        int i = preIndices.size() - 1;
        int j = suffIndices.size() - 1;
        while (i >= 0 && j >= 0) {
            int pi = preIndices.get(i);
            int si = suffIndices.get(j);
            if (pi == si) {
                return pi;
            } if (pi > si) {
                i--;
            } else {
                j--;
            }
        }

        return -1;
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
        List<Integer> indices;

        public TrieNode() {
            children = new TrieNode[26];
            indices = new LinkedList<>();
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
}
