package daily;

import java.util.Stack;

public class P775IdealPerm {
    public boolean isIdealPermutation(int[] nums) {
        final int n = nums.length;
        int local = 0;
        int global = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && nums[i] > nums[i + 1]) {
                local++;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                global++;
                stack.pop();
            }
            stack.push(nums[i]);
        }

        System.out.println("local " + local + ", global " + global);

        return local == global;
    }
}
