package utils;

/**
 * 并查集
 *
 * @author god-jiang
 * @date 2020/09/17 21:20
 */
public class UnionFind {
    int[] ans;

    public UnionFind(int n) {
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
    }

    public void union(int x, int y) {
        ans[find(x)] = find(y);
    }

    public int find(int index) {
        if (ans[index] != index) {
            ans[index] = find(ans[index]);
        }
        return ans[index];
    }
}
