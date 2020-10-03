package leetcode.dfs;

import java.util.*;

/**
 * 回溯算法51，N皇后
 *
 * @author god-jiang
 */
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    List<String> list = null;

    public List<List<String>> solveNQueens(int n) {
        int[] result = new int[n];
        dfs(n, 0, result);
        return res;
    }

    public void dfs(int n, int row, int[] result) {
        if (n == row) {
            // 找到可行解，输出
            addList(result);
        } else {
            for (int i = 0; i < n; i++) {
                if (check(row, i, result)) {
                    result[row] = i;
                    dfs(n, row + 1, result);
                }
            }
        }
    }

    public boolean check(int row, int col, int[] result) {
        for (int i = 0; i < row; i++) {
            // 行已经确定没问题了，现在确认列和对角线
            if (col == result[i] || Math.abs(result[i] - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    public void addList(int[] result) {
        list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length; j++) {
                if (j == result[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
