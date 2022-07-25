package hot100;

public class P309SellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        int[] dp = new int[n];
        dp[1] = Math.max(0, prices[1] - prices[0]);
        int result = dp[1];
        for (int i = 2; i < n; i++) {
            int k = 1;
            for (int j = k; j < i; j++) {
                if (prices[j] < prices[k]) {
                    k = j;
                }
                int p = prices[i] - prices[k];
                dp[i] = Math.max(dp[i], p > 0 ? dp[k - 1] + p : dp[i - 1]);
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
