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
                    System.out.println("\n-----\nBefore calc " + Arrays.deepToString(matrix));
                    int area = calcArea(matrix, i, j);
                    maxArea = Math.max(area, maxArea);
                    System.out.println("After  calc " + Arrays.deepToString(matrix));
                }
            }
        }

        return maxArea;
    }

    private int calcArea(char[][] matrix, int i, int j) {
        int maxLen = Math.min(m - i, n - j);
        int x = i;
        int y = j;
        boolean allOne = true;
        for (x = i; x < i + maxLen; x++) {
            for (y = j; y < j + maxLen; y++) {
                if (matrix[x][y] == '0') {
                    allOne = false;
                    break;
                }
            }
            if (!allOne) {
                break;
            }
        }
        int len = Math.min(x - i, y - j);
        if (len == 0) {
            if (x - i != 0 || y != j) {
                len = 1;
            }
        }
        System.out.println("i -> " +i + ", j " + j + ", x " +x+", y " + y + ", len " + len);
        int area = len * len;
        for (x = i; x < i + len; x++) {
            for (y = j; y < j + len; y++) {
                matrix[x][y] = '2';
            }
        }
        return area;
    }
}
