package leetcode;

/**
 * leetcode37，解数独
 *
 * @author god-jiang
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int r, int c) {
        if (c == 9) {
            return dfs(board, r + 1, 0);
        }
        if (r == 9) {
            return true;
        }

        for (int i = r; i < 9; i++) {
            for (int j = c; j < 9; j++) {
                if (board[i][j] != '.') {
                    return dfs(board, i, j + 1);
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(board, i, j, k)) {
                        continue;
                    }
                    board[i][j] = k;
                    if (dfs(board, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 判断行，列，3*3方格内不重复
     *
     * @param board
     * @param r
     * @param c
     * @param k
     * @return
     */
    public boolean isValid(char[][] board, int r, int c, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == k) {
                return false;
            }
            if (board[i][c] == k) {
                return false;
            }
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == k) {
                return false;
            }
        }
        return true;
    }
}
