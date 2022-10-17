package daily;

import java.util.LinkedList;
import java.util.Queue;

public class P904TotalFruits {
    public int totalFruit(int[] fruits) {
        int[] basket = {fruits[0], -1};
        int left = 0;
        int result = 1;
        for (int right = 1; right < fruits.length; right++) {
            if (basket[1] == -1 || basket[0] == fruits[right] || basket[1] == fruits[right]) {
                if (basket[1] == -1 && basket[0] != fruits[right]) {
                    basket[1] = fruits[right];
                }
            } else {
                basket[0] = fruits[right - 1];
                basket[1] = fruits[right];
                int j = right - 1;
                while (j >= left && fruits[j] == fruits[right - 1]) {
                    j--;
                }
                left = j + 1;
            }
            result = Math.max(right - left + 1, result);
        }

        return result;
    }
}