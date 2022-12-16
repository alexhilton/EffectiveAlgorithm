package backtracking;

import java.util.ArrayList;
import java.util.List;

public class P816Coordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            String x = s.substring(1, i);
            if (invalid(x)) {
                continue;
            }
            sb.append(x);
            sb.append(", ");
            String y = s.substring(i, s.length() - 1);
            if (invalid(y)) {
                continue;
            }
            sb.append(y);
            sb.append(")");
            result.add(sb.toString());
        }
        return result;
    }

    private boolean invalid(String c) {
        return c.length() > 1 && c.charAt(0) == '0' && c.charAt(c.length() - 1) == '0';
    }
}
