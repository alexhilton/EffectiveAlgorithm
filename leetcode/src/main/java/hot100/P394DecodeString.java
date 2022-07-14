package hot100;

import java.util.Arrays;
import java.util.Stack;

public class P394DecodeString {
    public static String decodeString(String s) {
        String[] parts = s.split("\\[");
        System.out.println(Arrays.deepToString(parts));

        Stack<Integer> count = new Stack<>();
        Stack<Integer> start = new Stack<>();
        Stack<Integer> end = new Stack<>();
        Stack<String> payloads = new Stack<>();
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (count.isEmpty() && Character.isAlphabetic(ch)) {
                int j = i;
                while (j < s.length() && Character.isAlphabetic(s.charAt(j))) {
                    result.append(s.charAt(j));
                    j++;
                }
                i = j;
            } else if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                count.push(Integer.valueOf(s.substring(i, j)));
                i = j;
            } else if (Character.isAlphabetic(ch)) {
                int j = i;
                while (j < s.length() && Character.isAlphabetic(s.charAt(j))) {
                    j++;
                }
                payloads.push(s.substring(i, j));
                i = j;
            } else if (ch == ']') {
                int c = count.pop();
                String str = payloads.pop();
                for (int k = 0; k < c; k++) {
                    result.append(str);
                }
                i++;
            } else {
                i++;
            }
        }

        return result.toString();
    }
}
