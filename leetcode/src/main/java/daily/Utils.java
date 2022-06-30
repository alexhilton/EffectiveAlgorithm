package daily;

public class Utils {
    public static void driveTable(String func, int[] values) {
        StringBuilder sb = new StringBuilder();
        sb.append("class Solution {");
        sb.append(String.format("\n    public int %s(int n) {", func));
        sb.append("\n        int[] result = {");
        String sep = "";
        for (int i = 0; i < values.length; i++) {
            sb.append(sep);
            if (i % 6 == 0) {
                sb.append("\n            ");
            }
            sb.append(values[i]);
            sep = ",";
        }
        sb.append("\n        };\n");
        sb.append("\n        return result[n - 1];");
        sb.append("\n    }");
        sb.append("\n}");
        System.out.println(sb);
    }
}
