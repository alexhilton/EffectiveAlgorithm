package numbers;

import java.util.HashMap;
import java.util.Map;

// Chapter 1, Section 2
public class Binaries {
    // Question #5 solution 2
    public static int maxProduct2(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                flags[i] |= 1 << (ch - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }

        return result;
    }

    // Question #5
    public static int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                flags[i][ch - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }

                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }

        return result;
    }

    // Question #4
    // O(32*n)
    public static int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (n >> (31 - i)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            // remainder is 1 or 0
            result = (result << 1) + bitSums[i] % 3;
        }

        return result;
    }

    // Question #4
    // Bruteforce version of single number
    // Hash has best O(1) worst O(n^2)
    // So it is generally O(n)
    public static int singleNumberBruteforce(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            int count = countMap.getOrDefault(n, 0);
            countMap.put(n, count + 1);
        }
        for (int n : nums) {
            int count = countMap.get(n);
            if (count == 1) {
                return n;
            }
        }

        // Should not happen
        return 0;
    }

    // Question #3, solution #3
    // O(n)
    public static int[] countBits3(int num) {
        int[] result = new int[num + 1];
        result[0] = 0; // Make this obvious
        for (int i = 1; i <= num; i++) {
            // when i = 1, i >> 1 is 0, it is safe.
            // real O(1)
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    // Question #3, solution #2
    // O(n)
    public static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        result[0] = 0; // Make this obvious.
        for (int i = 1; i <= num; i++) {
            // when i = 1, i&(i-1) is 0, so it is safe.
            // real O(1)
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }

    // Question #3
    // O(kn)
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0; // 0 has no bits
        for (int n = 1; n <= num; n++) {
            int m = n;
            // O(k), worst is O(32)
            while (m != 0) {
                result[n]++;
                m = m & (m - 1);
            }
        }

        return result;
    }

    // Question #3
    // Bruteforce version. O(n*32)
    public static int[] countBitsBruteforce(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int n = 1; n <= num; n++) {
            int m = n;
            // O(32) for integer, because you must move 32 times
            while (m != 0) {
                if ((m & 0x01) != 0) {
                    result[n]++;
                }
                m = m >> 1;
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
