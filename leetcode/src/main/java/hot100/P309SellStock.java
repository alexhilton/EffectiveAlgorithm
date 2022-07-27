package hot100;

public class P309SellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int pf = -prices[0];
        int pg = 0;
        int ph = 0;

        for (int i = 1; i < n; i++) {
            int f = Math.max(pf, ph - prices[i]);
            int g = pf + prices[i];
            int h = Math.max(pg, ph);
            pf = f;
            pg = g;
            ph = h;
        }

        return Math.max(pg, ph);
    }
}
