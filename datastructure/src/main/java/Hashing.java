import java.util.ArrayList;
import java.util.stream.IntStream;

public class Hashing {
    public static final int MOD = 1_000_000_000 + 7;

    // Other possible primes are: 131, 1313, 13131, 131313
    public static final int P = 31;

    public static int hash(String s) {
        return hashBytes(s.toCharArray());
    }

    /*
     * Polynomial multiplication of prime:
     * hash = c[0]*P^(n-1) + c[1]*P^(n-2) + ... + s[n-1]
     */
    public static int hashBytes(char[] chars) {
        int hash = 0;
        for (char ch : chars) {
            hash = P * hash + ch;
        }

        return hash;
    }

    public static ArrayList<Integer> rollingHash(String payload, int window, int p, int mod) {
        final int n = payload.length();
        ArrayList<Integer> hashValues = new ArrayList<>(n - window + 1);
        int power = 1;
        for (int i = 0; i < window - 1; i++) {
            power *= p;
            power %= mod;
        }

        int hash = 0;
        for (int i = 0; i < window; i++) {
            hash = (hash * p + payload.charAt(i)) % mod;
        }
        hashValues.add(hash);

        for (int i = 1; i < n - window + 1; i++) {
            hash = (hash - power * payload.charAt(i - 1)) % mod;
            hash = (hash * p + payload.charAt(i + window - 1)) % mod;
            hashValues.add(hash);
        }

        return hashValues;
    }

    public static void main(String[] args) {
        String s = "Hello, world of Hashing!";
        System.out.println(s + ", hash -> " + hash(s));

        String payload = "abcabcabc";
        int window = 3;
        ArrayList<Integer> hashes = rollingHash(payload, window, 31, MOD);
        System.out.println("Rolling hash of " + payload + ", window size " + window);
        IntStream.range(0, hashes.size())
                .mapToObj(i -> i + "->" + payload.substring(i, i + window) + " whose hash is " + hashes.get(i))
                .forEach(System.out::println);
    }
}
