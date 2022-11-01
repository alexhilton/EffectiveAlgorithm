package daily;

public class P1662StringArrayEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        final int m = word1.length;
        final int n = word2.length;
        int i = 0;
        int j = 0;
        int wc1 = 0;
        int wc2 = 0;
        while (i < m && j < n) {
            if (word1[i].charAt(wc1) != word2[j].charAt(wc2)) {
                return false;
            }
            wc1++;
            if (wc1 >= word1[i].length()) {
                wc1 = 0;
                i++;
            }
            wc2++;
            if (wc2 >= word2[j].length()) {
                wc2 = 0;
                j++;
            }
        }

        return i == m && j == n;
    }
}
