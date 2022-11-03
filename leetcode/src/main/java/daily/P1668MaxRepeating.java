package daily;

public class P1668MaxRepeating {
    public int maxRepeating(String sequence, String word) {
        final int n = sequence.length();
        final int m = word.length();
        int result = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            for (int k = 0; k < m; k++) {
                if (sequence.charAt(j) == word.charAt(k)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j - i == m) {
                result++;
                i = j;
            } else {
                i++;
            }
        }

        return result;
    }
}
