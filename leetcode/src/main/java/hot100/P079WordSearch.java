package hot100;

public class P079WordSearch {
    private static final char mark = '0';
    private static final int[][] DIRS = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };
    private int m;
    private int n;
    private int len;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        len = word.length();
        final char head = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != mark) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int start) {
        if (start >= len) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (board[i][j] != word.charAt(start)) {
            // board[i][j] = mark;
            return false;
        }
        board[i][j] = mark;
        boolean res = false;
        for (int[] d : DIRS) {
            int r = i + d[0];
            int c = j + d[1];

            if (dfs(board, r, c, word, start + 1)) {
                res = true;
            }
        }

        return res;
    }
}
