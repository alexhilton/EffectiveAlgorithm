package numbers;

// Chapter 1, Section 2
public class Binaries {
    // Question #3
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0; // 0 has no bits
        for (int n = 1; n <= num; n++) {
            int m = n;
            while (m != 0) {
                result[n]++;
                m = m & (m - 1);
            }
        }

        return result;
    }

    // Question #2
    public static String stringAddition(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }

        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
