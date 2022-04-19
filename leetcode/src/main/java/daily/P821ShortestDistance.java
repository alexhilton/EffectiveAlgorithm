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
            int prev = k > 0 ? (indices.get(k) + indices.get(k - 1)) / 2 + 1 : 0;
            for (int i = prev; i <= indices.get(k); i++) {
                result[i] = indices.get(k) - i;
            }
            int next = k + 1 >= indices.size() ? indices.size() - 1 : (indices.get(k) + indices.get(k + 1)) / 2 + 1;
            for (int j = indices.get(k); j < next; j++) {
                result[j] = j - indices.get(k);
            }
        }

        return result;
    }
}
