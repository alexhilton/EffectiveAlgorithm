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

    public static void main(String[] args) {
        String s = "Hello, world of Hashing!";
        System.out.println(s + ", hash -> " + hash(s));
    }
}
