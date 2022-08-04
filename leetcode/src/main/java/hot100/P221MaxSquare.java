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

        int area = len * len;
        for (int x = i; x < i + len - 1; x++) {
            for (int y = j; y < j + len - 1; y++) {
                matrix[x][y] = '2';
            }
        }
        return area;
    }
}
