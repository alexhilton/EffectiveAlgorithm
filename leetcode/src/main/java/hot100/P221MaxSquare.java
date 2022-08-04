package hot100;

import java.util.Arrays;

public class P221MaxSquare {
    private int m;
    private int n;

    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
//                    dump("Before calc ", matrix);
                    int len = calcArea(matrix, i, j);
                    maxArea = Math.max(len * len, maxArea);
//                    dump("After  calc ", matrix);
                    if (len > (Math.min(m, n) / 2 + 1)) {
                        return maxArea;
                    }
                }
            }
        }

        return maxArea;
    }

    private int calcArea(char[][] matrix, int i, int j) {
        int maxLen = Math.min(m - i, n - j) - 1;
        int len = 1;
        for (; len <= maxLen; len++) {
            boolean allOne = true;
            for (int x = i; x <= i + len; x++) {
                if (matrix[x][j + len] == '0') {
                    allOne = false;
                    break;
                }
            }
            if (allOne) {
                for (int y = j; y <= j + len; y++) {
                    if (matrix[i + len][y] == '0') {
                        allOne = false;
                        break;
                    }
                }
            }
            if (!allOne) {
                break;
            }
        }
        System.out.println(" [" + i + ", " + j + "] -> len " + len);
        return len;
    }

    private void dump(String msg, char[][] matrix) {
        System.out.println("\n-------" + msg + "---------");
        System.out.println("[");
        for (char[] chs : matrix) {
            System.out.println("\t" + Arrays.toString(chs) + ",");
        }
        System.out.println("]\n");
    }
}
