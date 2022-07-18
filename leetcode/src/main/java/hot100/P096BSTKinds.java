package hot100;

import daily.Utils;

public class P096BSTKinds {
    public static int numTrees(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2*i + 1) / (i + 2);
        }

        return (int) c;
    }

    public static void main(String[] args) {
        int n = 19;
        int[] trees = new int[n];
        for (int i = 1; i <= n; i++) {
            trees[i - 1] = numTrees(i);
        }
        Utils.driveTable("numTrees", trees);
    }
}
