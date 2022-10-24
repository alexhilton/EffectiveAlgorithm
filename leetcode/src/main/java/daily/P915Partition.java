package daily;

import java.util.Stack;

public class P915Partition {
    public int partitionDisjoint(int[] nums) {
        final int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int bottom = -1;
        for (int i = 0; i < n; i++) {
            System.out.println(" i -> " + i + ", " + nums[i]);
            if (stack.isEmpty() || nums[stack.peek()] <= nums[i]) {
                if (stack.isEmpty()) {
                    bottom = i;
                }
                stack.push(i);
            } else {
                int t = stack.pop();
                while (!stack.isEmpty() && nums[bottom] > nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    bottom = t;
                }
                stack.push(t);
            }
            System.out.println("stack " + stack);
        }
        while (stack.size() > 2) {
            stack.pop();
        }
        return stack.peek();
    }
}
