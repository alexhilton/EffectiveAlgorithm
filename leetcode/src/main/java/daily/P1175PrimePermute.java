package daily;

public class P1175PrimePermute {
    private static final int MOD = 1000000007;

    public static int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        return (int) (factorial(primeCount) * factorial(n - primeCount) % MOD);
    }

    private static boolean isPrime(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            result %= MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] perms = new int[100];
        for (int i = 0; i < n; i++) {
            perms[i] = numPrimeArrangements(i + 1);
        }

        Utils.driveTable("numPrimeArrangements", perms);
    }
}
