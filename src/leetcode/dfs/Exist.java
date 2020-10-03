package leetcode.dfs;


/**
 * 回溯算法79，单词搜索
 *
 * @author god-jiang
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, flag, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] flag, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        flag[i][j] = true;
        if (dfs(board, word, flag, i + 1, j, index + 1) || dfs(board, word, flag, i, j + 1, index + 1)
                || dfs(board, word, flag, i - 1, j, index + 1) || dfs(board, word, flag, i, j - 1, index + 1)) {
            return true;
        }
        flag[i][j] = false;
        return false;
    }
}
