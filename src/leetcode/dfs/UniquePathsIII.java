package leetcode.dfs;

/**
 * 回溯算法980，不同路径三
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 * @author god-jiang
 */
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int x = 0;
        int y = 0;
        // grid[x][y]=2也要count++，所以直接初始化为1
        int count = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    continue;
                }
                if (grid[i][j] == 0) {
                    ++count;
                }
            }
        }
        return dfs(grid, x, y, count);
    }

    public int dfs(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return count == 0 ? 1 : 0;
        }
        // 标记走过的路
        grid[x][y] = -1;
        int res = 0;
        res += dfs(grid, x + 1, y, count - 1);
        res += dfs(grid, x, y + 1, count - 1);
        res += dfs(grid, x - 1, y, count - 1);
        res += dfs(grid, x, y - 1, count - 1);
        // 回溯
        grid[x][y] = 0;
        return res;
    }
}
