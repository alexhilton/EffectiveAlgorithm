package daily;

public class P779KthGrammar {
    public int kthGrammar(int n, int k) {
        System.out.println(" n = " + n + ", k = " + k);
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1 - (k & 0x01);
        }
        int x = kthGrammar(n - 1, (k + 1) >> 1);
        System.out.println("   x = " + x);
        if ((k & 0x01) == 0) {
            return 1 - x;
        } else {
            return x;
        }
    }
}
