package hot100;

import java.util.Arrays;
import java.util.Stack;

public class P042RainTrap {
    public int trap(int[] height) {
        final int n = height.length;
        System.out.println("input array -> " + Arrays.toString(height));
        Stack<Integer> stack = new Stack<>();
        int[] trapMap = new int[n];
        int[] preSum = new int[n];
        stack.push(0);
        preSum[0] = height[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + height[i];
            System.out.println(" i " + i + ", [" + height[i] + "]");
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() > 1 && height[i] >= height[stack.peek()]) {
                    int t = stack.pop();
                    trapMap[t] = 0;
                }
                final int left = stack.peek();
                final int w = i - left - 1;
                final int h = Math.min(height[i], height[left]);
                final int sum = preSum[i - 1] - preSum[left];
                System.out.println("     left -> " + left + " [" + height[left] + "]");
                System.out.println("     w " + w + ", h "+ h + " sum " + sum + ", trap -> " + (w*h-sum));
                trapMap[i] = Math.max(0, w * h - sum);
                if (height[i] >= height[left]) {
                    stack.pop();
                }
                stack.push(i);
            }
            System.out.println(" pre sum " + Arrays.toString(preSum));
            System.out.println(" tap map " + Arrays.toString(trapMap));
            System.out.println(" stack -> " + stack);
        }

        return Arrays.stream(trapMap).sum();
    }
}
