package daily;

public class P1668MaxRepeating {
    public int maxRepeating(String sequence, String word) {
        final int n = sequence.length();
        final int m = word.length();
        int result = 0;
        int k = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            for (int x = 0; j < n && x < m; x++) {
                if (sequence.charAt(j) == word.charAt(x)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j - i == m) {
                k++;
                result = Math.max(result, k);
                i = j;
            } else {
                if (k > 0) {
                    i -= m;
                    k = 0;
                }
                i++;
            }
        }

        return result;
    }
}
