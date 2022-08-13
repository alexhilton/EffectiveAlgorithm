package daily;

import java.util.Stack;

public class P768MostChunks {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = arr[0];
        stack.push(arr[0]);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < stack.peek() || arr[i] < max) {
                stack.push(arr[i]);
            } else {
                count++;
                stack.clear();;
                stack.push(arr[i]);
                max = arr[i];
            }
        }
        return count;
    }
}
