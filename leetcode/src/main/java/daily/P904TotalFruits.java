package daily;

import java.util.LinkedList;
import java.util.Queue;

public class P904TotalFruits {
    public int totalFruit(int[] fruits) {
        int[] basket = {fruits[0], -1};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(fruits[0]);
        int result = 1;
        for (int i = 1; i < fruits.length; i++) {
            if (basket[1] == -1 || basket[0] == fruits[i] || basket[1] == fruits[i]) {
                if (basket[1] == -1 && basket[0] != fruits[i]) {
                    basket[1] = fruits[i];
                }
                queue.offer(fruits[i]);
            } else {
                queue.clear();
                basket[0] = fruits[i - 1];
                basket[1] = fruits[i];
                for (int j = i - 1; j >= 0 && fruits[j] == fruits[i - 1]; j--) {
                    queue.offer(fruits[j]);
                }
                queue.offer(fruits[i]);
            }
            result = Math.max(queue.size(), result);
        }

        return result;
    }
}