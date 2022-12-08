package backtracking;

import daily.Utils;

import java.awt.image.ColorModel;

public class P052NQueens {
    private int n;
    private int[] queens;
    private boolean[] columns;
    private boolean[] diagonal45;
    private boolean[] diagonal135;
    private int result;

    public int totalNQueens(int n) {
        this.n = n;
        queens = new int[n];
        columns = new boolean[n];
        diagonal45 = new boolean[2 * n + 1];
        diagonal135 = new boolean[2 * n + 1];
        result = 0;

        solveQueen(0);

        return result;
    }

    private void solveQueen(int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!columns[col] && !diagonal45[row - col + n] && !diagonal135[row + col]) {
                queens[row] = col;
                columns[col] = true;
                diagonal45[row - col + n] = true;
                diagonal135[row + col] = true;
                solveQueen(row + 1);
                queens[row] = -1;
                columns[col] = false;
                diagonal45[row - col + n] = false;
                diagonal135[row + col] = false;
            }
        }
    }

    public static void main(String[] args) {
        P052NQueens inst = new P052NQueens();
        int[] result = new int[9];
        for (int i = 1; i < 10; i++) {
            result[i - 1] = inst.totalNQueens(i);
        }
        Utils.driveTable("totalNQueens", result);
    }
}
