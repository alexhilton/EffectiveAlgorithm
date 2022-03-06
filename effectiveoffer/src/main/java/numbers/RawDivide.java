package numbers;

// Chapter 1, Section 1
public class RawDivide {
    // Question #1
    public static int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    /*
     * Dividend and divisor are modified to negative before passing here.
     * So should always use <=
     */
    private static int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }

            result += quotient;
            dividend -= value;
        }

        return result;
    }

    // Bruteforce version
    public static int divideBruteforce(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 0;
        if (dividend > 0) {
            sign++;
            dividend = -dividend;
        }
        if (divisor > 0) {
            sign++;
            divisor = -divisor;
        }
        int result = 0;
        while (dividend <= divisor) {
            result++;
            dividend -= divisor;
        }

        return sign == 1 ? -result : result;
    }
}
