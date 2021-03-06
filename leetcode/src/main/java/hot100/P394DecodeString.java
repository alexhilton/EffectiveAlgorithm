package hot100;

import java.util.Stack;

public class P394DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
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
                StringBuilder sb = new StringBuilder();
                while (!payloads.isEmpty() && !payloads.peek().equals("[")) {
                    // Pay attention to order, stack is FILO, so always insert at head.
                    sb.insert(0, payloads.pop());
                }
                if (!payloads.isEmpty()) {
                    // discard '['
                    payloads.pop();
                }

                int c = count.pop();
                StringBuilder ssb = new StringBuilder();
                for (int k = 0; k < c; k++) {
                    ssb.append(sb);
                }
                if (count.isEmpty()) {
                    // No recursive, so add to result directly.
                    result.append(ssb);
                } else {
                    // Recursive, in to stack, waiting for later ']'
                    payloads.push(ssb.toString());
                }
                i++;
            } else {
                // must be '[', into stack as a delimiter
                payloads.push(Character.toString(ch));
                i++;
            }
        }

        return result.toString();
    }
}
