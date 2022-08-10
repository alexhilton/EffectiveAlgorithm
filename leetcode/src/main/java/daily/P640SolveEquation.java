package daily;

public class P640SolveEquation {
    public String solveEquation(String equation) {
        int sign = 1;
        int a = 0;
        int b = 0;
        char op = '+';

        final int n = equation.length();
        int i = 0;
        while (i < n) {
            final char ch = equation.charAt(i);
            if (ch == '=') {
                sign = -1;
                op = '+';
                i++;
            } else if (ch == '+' || ch == '-') {
                op = ch;
                i++;
            } else if (ch == 'x') {
                a = operate(a, op, sign);
                i++;
            } else {
                // must be digit
                int j = i;
                while (j < n && Character.isDigit(equation.charAt(j))) {
                    j++;
                }
                int num = sign * Integer.parseInt(equation.substring(i, j));
                if (j < n && equation.charAt(j) == 'x') {
                    a = operate(a, op, num);
                    i = j + 1;
                } else {
                    b = operate(b, op, num);
                    i = j;
                }
            }
        }

        System.out.println("a = " + a + " b = " + b);
        if (a == 0) {
            return b == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-1 * b / a);
    }

    private int operate(int op1, char op, int op2) {
        if (op == '-') {
            return op1 - op2;
        }

        return op1 + op2;
    }
}
