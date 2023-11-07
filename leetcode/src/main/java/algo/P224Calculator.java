package algo;

import java.util.Stack;

public class P224Calculator {
    public int calculate(String s) {
        System.out.println("input str: [" + s + "]");
        char[] sc = s.replace(" ", "").toCharArray();
        int n = sc.length;
        Stack<Integer> stack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        stack.push(0);
        int i = 0;
        while (i < n) {
            final char ch = sc[i];
            if (ch == '(') {
                opStack.push(ch);
                i++;
            } else if (ch == ')') {
                while (opStack.peek() != '(') {
                    calc(stack, opStack);
                }
                opStack.pop(); // pop the '('
                i++;
            } else if (Character.isDigit(ch)) {
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(sc[j])) {
                    num = num * 10 + (sc[j] - '0');
                    j++;
                }
                stack.push(num);
                i = j;
            } else {
                if (i > 0 && (sc[i - 1] == '(' || sc[i - 1] == '+' || sc[i - 1] == '-')) {
                    stack.push(0);
                }
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    calc(stack, opStack);
                }
                opStack.push(ch);
                i++;
            }
        }
        System.out.println("stack " + stack);
        System.out.println("op stack " + opStack);
        while (/*stack.size() > 1 && */!opStack.isEmpty()) {
            System.out.println(" >> stack " + stack);
            System.out.println(" >> op stack " + opStack);
            calc(stack, opStack);
        }

        return stack.pop();
    }

    private void calc(Stack<Integer> stack, Stack<Character> opStack) {
        int b = stack.pop();
        int a = stack.pop();
        char op = opStack.pop();
        System.out.println(" calc " + a + " " + op + " " + b + " = " + operate(a, b, op));
        stack.push(operate(a, b, op));
    }

    private int operate(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
        }

        return 0;
    }

    public static void main(String[] args) {
        P224Calculator instance = new P224Calculator();

        System.out.println(instance.calculate("1 + 1") + " = 2");
        System.out.println(instance.calculate(" 2-1 + 2 ") + " = 3");
        System.out.println(instance.calculate("(1+(4+5+2)-3)+(6+8)") + " = 23");
        System.out.println(instance.calculate("-1") + " = -1");
        System.out.println(instance.calculate("-(1+3)") + " = -4");
        System.out.println(instance.calculate("1+(2+(3-4))") + " = 2");
        System.out.println(instance.calculate("(1+(4+5+2)+3)+(6+8)") + " = 29");
        System.out.println(instance.calculate("1-(-(-(-4+3-3+6) + 1)-4+2)") + " = 2");

        System.out.println(instance.calculate("- 2 + 1") + " = -1");
    }
}
