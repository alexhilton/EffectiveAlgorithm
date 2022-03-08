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

    public static void main(String[] args) {
        // Learn the basics of the Integer.
        System.out.println(String.format("Max byte %d, 0x%X, half 0x%X", Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE/2));
        System.out.println(String.format("Min byte %d, 0x%X, half 0x%X", Byte.MIN_VALUE, Byte.MIN_VALUE, (byte)(Byte.MIN_VALUE/2)));
        System.out.println(String.format("Max short %d, 0x%X, half 0x%X", Short.MAX_VALUE, Short.MAX_VALUE, Short.MAX_VALUE/2));
        System.out.println(String.format("Min short %d, 0x%X, half 0x%X", Short.MIN_VALUE, Short.MIN_VALUE, (short) (Short.MIN_VALUE/2)));
        System.out.println(String.format("Max Int %d, 0x%X, half 0x%X", Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE/2));
        System.out.println(String.format("Min Int %d, 0x%X, half 0x%X", Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE/2));

        System.out.println(String.format("Literal %d, 0x%X", 0xffffffff, 0xffffffff));
        System.out.println(String.format("Literal %d 0x%X", 0x80000001, 0x80000001));

        System.out.println(String.format("Max in %d (0x%X) + 1 = %d (0x%X)", Integer.MAX_VALUE, Integer.MAX_VALUE, (Integer.MAX_VALUE+1), (Integer.MAX_VALUE+1)));

        System.out.println(String.format("Min in %d (0x%X) - 1 = %d (0x%X)", Integer.MIN_VALUE, Integer.MIN_VALUE, (Integer.MIN_VALUE-1), (Integer.MIN_VALUE-1)));
    }
}
