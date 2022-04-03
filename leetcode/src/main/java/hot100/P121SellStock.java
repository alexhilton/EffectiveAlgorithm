package hot100;

public class P121SellStock {
    public static int bruteForce(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1, k = prices.length - 1; j <= k; j++, k--) {
                result = Math.max(result, prices[j] - prices[i]);
                result = Math.max(result, prices[k] - prices[i]);
            }
        }

        return result;
    }
}
