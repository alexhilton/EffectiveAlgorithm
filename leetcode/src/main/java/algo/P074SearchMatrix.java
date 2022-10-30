package algo;

public class P074SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        return qsearch(matrix, target, 0, 0, n - 1, m - 1);
    }

    private boolean qsearch(int[][] matrix, int target, int left, int top, int right, int bottom) {
        if (left > right || top > bottom) {
            return false;
        }
        int hc = left + ((right - left) >> 1);
        int vc = top + ((bottom - top) >> 1);
        System.out.println(" l " + left + " t " + top + " r " + right + " b " + bottom + ", hc " + hc + ", vc " + vc);
        if (matrix[vc][hc] == target) {
            return true;
        } else if (matrix[vc][hc] > target) {
            return qsearch(matrix, target, left, vc, hc - 1, vc) ||
                    qsearch(matrix, target, left, top, right, vc - 1);
        } else {
            return qsearch(matrix, target, hc + 1, vc, right, vc) ||
                    qsearch(matrix, target, left, vc + 1, right, bottom);
        }
    }
}
