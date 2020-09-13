package leetcode;

/**
 * leetcode79，单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网络中。
 * @author god-jiang
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] used, int x, int y, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || used[x][y] || index >= word.length() || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        used[x][y] = true;


        if (dfs(board, word, used, x + 1, y, index + 1) || dfs(board, word, used, x, y + 1, index + 1) ||
                dfs(board, word, used, x - 1, y, index + 1) || dfs(board, word, used, x, y - 1, index + 1)) {
            return true;
        }
        used[x][y] = false;
        return false;
    }
}
