import java.util.List;

public class Utils {
    public static void integerTricks() {
        int n = 10;
        System.out.println(String.format("n is %d, x 2 = %d, / 2 = %d", n, n << 1, n >> 1));

        System.out.println("Math pow(2, k to " + n + ")");
        for (int k = 0; k <= n; k++) {
            System.out.println(String.format("Math.pow(2, %d) = %d, 1 << %d = %d", k,
                    (int) Math.pow(2, k), k, 1 << k));
        }
    }

    public static void main(String[] args) {
        integerTricks();
    }
}
