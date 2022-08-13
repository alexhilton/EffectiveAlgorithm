package daily;

import java.util.Stack;

public class P768MostChunks {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = arr[0];
        stack.push(arr[0]);
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= stack.peek() || arr[i] < max) {
                stack.push(arr[i]);
            } else {
                count += clearStack(stack);
                stack.push(arr[i]);
                max = arr[i];
            }
        }
        if (!stack.isEmpty()) {
            count += clearStack(stack);
        }
        return count;
    }

    private int clearStack(Stack<Integer> stack) {
        int top = stack.pop();
        int count = 1;
        while (!stack.isEmpty()) {
            if (top != stack.pop()) {
                stack.clear();
                return 1;
            }
            count++;
        }
        return count;
    }
}
