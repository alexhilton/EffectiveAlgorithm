public class AuxiliaryMatrix {
    private int[][] preSum;
    private int[][] matrix;
    private int m;
    private int n;

    public AuxiliaryMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        init();
    }

    private void init() {
        preSum = new int[m][n];

        if (m < 1 || n < 1) {
            return;
        }

        preSum[0][0] = matrix[0][0];
        preSum[1][0] = preSum[0][0] + matrix[1][0];
        preSum[0][1] = preSum[0][0] + matrix[0][1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] + matrix[i][j] - preSum[i - 1][j - 1];
            }
        }
    }

    public int regionSum(int r1, int c1, int r2, int c2) {
        if (r1 == 0 && c1 == 0) {
            return preSum[r2][c2];
        }
        return preSum[r2][c2] - preSum[r2][c1 - 1] - preSum[r1 - 1][c2] + preSum[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2},
                {4, 5, 6, 7},
                {8, 9, 0, 1}
        };
        AuxiliaryMatrix am = new AuxiliaryMatrix(matrix);

        System.out.println("34 = " + am.regionSum(0, 0, 2, 2));
        System.out.println("14 = " + am.regionSum(1, 1, 2, 2));
        System.out.println("42 = " + am.regionSum(1, 1, 3, 3));
    }
}
