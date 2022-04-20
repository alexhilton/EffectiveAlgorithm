package daily;

import java.util.ArrayList;
import java.util.List;

public class P821ShortestDistance {
    public static int[] shortestToChar(String s, char c) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indices.add(i);
            }
        }

        int[] result = new int[s.length()];
        for (int k = 0; k < indices.size(); k++) {
            int center = indices.get(k);
            int leftRadius = k > 0 ? (center - indices.get(k - 1)) / 2 : center;
            for (int i = center - 1; i >= center - leftRadius; i--) {
                result[i] = center - i;
            }
            int rightRadius = k + 1 >= indices.size() ? s.length() - center - 1 : (indices.get(k + 1) - center) / 2;
            for (int j = center + 1; j <= center + rightRadius; j++) {
                result[j] = j - center;
            }
        }

        return result;
    }
}
