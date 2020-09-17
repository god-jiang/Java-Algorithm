package leetcode;

/**
 * leetcode684，冗余连接
 *
 * @author god-jiang
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        UnionFind uf = new UnionFind(size + 1);
        int[] res = new int[2];
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (uf.find(node1) != uf.find(node2)) {
                // 不在同一个集合中，合并
                uf.union(node1, node2);
            } else {
                // 在同一个集合中，形成闭环
                res = edge;
            }
        }
        return res;
    }

    /**
     * 并查集
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
}
