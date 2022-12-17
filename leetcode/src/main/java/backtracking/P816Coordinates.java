package backtracking;

import java.util.ArrayList;
import java.util.List;

public class P816Coordinates {
    private static final String FMT = "(%s, %s)";

    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            String x = s.substring(1, i);
            if (invalid(x)) {
                continue;
            }
            String y = s.substring(i, s.length() - 1);
            if (invalid(y)) {
                continue;
            }

            if (!(needDot(x) || needDot(y))) {
                result.add(String.format(FMT, x, y));
            }
            dotit(result, x, y);
        }
        return result;
    }

    private boolean invalid(String c) {
        return c.length() > 1 && c.charAt(0) == '0' && c.charAt(c.length() - 1) == '0';
    }

    private boolean needDot(String c) {
        return c.length() > 1 && c.charAt(0) == '0';
    }

    private void dotit(List<String> result, String x, String y) {
        List<String> dottedX = new ArrayList<>();
        for (int i = 1; i < x.length(); i++) {
            String front = x.substring(0, i);
            String end = x.substring(i, x.length());
            if (validFront(front) && validEnd(end)) {
                dottedX.add(front + "." + end);
            }
        }
        List<String> dottedY = new ArrayList<>();
        for (int i = 1; i < y.length(); i++) {
            String front = y.substring(0, i);
            String end = y.substring(i, y.length());
            if (validFront(front) && validEnd(end)) {
                dottedY.add(front + "." + end);
            }
        }
        if (!needDot(y)) {
            for (String dx : dottedX) {
                result.add(String.format(FMT, dx, y));
            }
        }
        if (!needDot(x)) {
            for (String dy : dottedY) {
                result.add(String.format(FMT, x, dy));
            }
        }
        for (String dx : dottedX) {
            for (String dy : dottedY) {
                result.add(String.format(FMT, dx, dy));
            }
        }
    }

    private boolean validFront(String f) {
        if (f.length() == 1 && f.charAt(0) == '0') {
            return true;
        }
        return !(f.charAt(0) == '0' || f.charAt(f.length() - 1) == '0');
    }

    private boolean validEnd(String e) {
        if (e.length() == 1 && e.charAt(0) == '0') {
            return false;
        }
        return e.charAt(e.length() - 1) != '0';
    }
}
