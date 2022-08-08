package daily;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P636ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Func> stack = new Stack<>();
        for (String log : logs) {
            Func f = parse(log);
            dump("before", f, stack, result);
            if (stack.isEmpty() || stack.peek().id != f.id || !f.done) {
                stack.push(f);
            } else {
                Func fstart = stack.pop();
                int execTime = f.time - fstart.time + 1;
                result[f.id] += execTime;
                if (!stack.isEmpty()) {
                    int parentId = stack.peek().id;
                    result[parentId] -= execTime;
                }
            }

            dump("after", null, stack, result);
        }

        return result;
    }

    private Func parse(String log) {
        String[] parts = log.split(":");
        Func f = new Func(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]));
        f.done = parts[1].equals("end");
        return f;
    }

    private class Func {
        int id;
        boolean done;
        int time;

        public Func(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Func{" +
                    "id=" + id +
                    ", done=" + done +
                    ", time=" + time +
                    '}';
        }
    }

    private void dump(String header, Func f, Stack<Func> stack, int[] result) {
        System.out.println("\n-----" + header + "-------");
        if (f != null) {
            System.out.println("\tf " + f);
        }
        System.out.println("\tstack is " + stack);
        System.out.println("\tresult is " + Arrays.toString(result));
    }
}
