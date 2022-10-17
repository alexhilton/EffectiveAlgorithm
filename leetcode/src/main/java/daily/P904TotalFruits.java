package daily;

public class P904TotalFruits {
    public int totalFruit(int[] fruits) {
        int[] basket = {fruits[0], -1};
        int[] basketCount = {1, 0};
        int result = 1;
        for (int i = 1; i < fruits.length; i++) {
            if (basket[1] == -1 || basket[0] == fruits[i] || basket[1] == fruits[i]) {
                if (basket[1] == -1 && basket[0] != fruits[i]) {
                    basket[1] = fruits[i];
                }
                if (basket[0] == fruits[i]) {
                    basketCount[0]++;
                } else if (basket[1] == fruits[i]) {
                    basketCount[1]++;
                }
                if (basket[0] == fruits[i]) {
                    swap(basket);
                    swap(basketCount);
                }
            } else {
                if (i - 2 >= 0 && fruits[i - 2] != basket[0]) {
                    basketCount[0] = 1;
                } else {
                    basketCount[0] = basketCount[1];
                }
                basket[0] = basket[1];
                if (basket[0] == fruits[i]) {
                    basketCount[0]++;
                    basket[1] = -1;
                    basketCount[1] = 0;
                } else {
                    basket[1] = fruits[i];
                    basketCount[1] = 1;
                }
            }
            result = Math.max(basketCount[0] + basketCount[1], result);
        }

        return result;
    }

    private static void swap(int[] a) {
        int t = a[1];
        a[1] = a[0];
        a[0] = t;
    }
}