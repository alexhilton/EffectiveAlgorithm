package daily;

import java.util.Stack;

public class P775IdealPerm {
    public boolean isIdealPermutation(int[] nums) {
        final int n = nums.length;
        int local = 0;
        int global = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i] > nums[i + 1]) {
                local++;
            }
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                global++;
                stack.pop();
            }
            stack.push(nums[i]);
        }

        return local == global;
    }
}
