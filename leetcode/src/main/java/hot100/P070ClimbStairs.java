package hot100;

import daily.Utils;

public class P070ClimbStairs {
    public static void climbStairs(int n) {
        int[] fibs = new int[n];
        fibs[0] = 1;
        fibs[1] = 2;
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        Utils.driveTable("climbStairs", fibs);
    }

    public static void main(String[] args) {
        climbStairs(45);
    }
}
