package hot100;

public class P048RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int radius = n >> 1;
        int[] tmp = new int[n];
        int end;
        for (int r = 0; r < radius; r++) {
            end = n - r;
            System.arraycopy(matrix[r], r, tmp, r, end);
            for (int k = r; k < end; k++) {
                int j = r + end - k - 1;
                matrix[r][k] = matrix[j][r];
            }
            for (int k = r; k < end; k++) {
                matrix[k][r] = matrix[end - 1][k];
            }
            for (int k = r; k < end; k++) {
                int j = r + end - k - 1;
                matrix[end - 1][k] = matrix[j][end - 1];
            }
            for (int k = r; k < end; k++) {
                matrix[k][end - 1] = tmp[k];
            }
        }
    }
}
