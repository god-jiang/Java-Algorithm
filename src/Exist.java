import java.util.Scanner;

public class Exist {
    public boolean exist(char[][] board, String word) {
        //初始化一个boolean类型的二维数组标记是否走过
        boolean[][] flag = new boolean[board.length][board[0].length];
        char[] str = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(board, i, j, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judge(char[][] board, int i, int j, boolean[][] flag, char[] str, int k) {
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] == true || board[i][j] != str[k]) {
            return false;
        }
        //如果k走到最后一步就是遍历完成
        if (k == str.length - 1) {
            return true;
        }
        flag[i][j] = true;
        if (judge(board, i + 1, j, flag, str, k + 1) ||
                judge(board, i - 1, j, flag, str, k + 1) ||
                judge(board, i, j + 1, flag, str, k + 1) ||
                judge(board, i, j - 1, flag, str, k + 1)) {
            return true;
        }
        //如果到这一步证明走不通，还原，走另外的路
        flag[i][j] = false;
        return false;
    }
}
