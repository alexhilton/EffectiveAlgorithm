package hot100;

import java.util.Stack;

public class P042RainTrap {
    public int trap(int[] height) {
        final int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i);
            } else {
                int sum = 0;
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    sum += height[stack.pop()];
                }
                if (!stack.isEmpty()) {
                    left = stack.peek();
                } else {
                    sum -= height[left];
                }
                final int w = i - left - 1;
                final int h = Math.min(height[i], height[left]);
                answer += w * h - sum;
                stack.push(i);
            }
        }

        return answer;
    }
}
