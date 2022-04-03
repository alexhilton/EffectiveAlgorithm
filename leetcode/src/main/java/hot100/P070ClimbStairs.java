package hot100;

public class P070ClimbStairs {
    public static void climbStairs(int n) {
        int[] fibs = new int[n];
        fibs[0] = 1;
        fibs[1] = 2;
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        sb.append("class Solution {");
        sb.append("\n    public int climbStairs(int n) {");
        sb.append("\n        int[] result = {");
        String sep = "";
        for (int i = 0; i < n; i++) {
            sb.append(sep);
            if (i % 6 == 0) {
                sb.append("\n            ");
            }
            sb.append(fibs[i]);
            sep = ",";
        }
        sb.append("\n        };\n");
        sb.append("\n        return result[n - 1];");
        sb.append("\n    }");
        sb.append("\n}");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        climbStairs(45);
    }
}
