package leetcode;

/**
 * 冗余连接二
 *
 * @author god-jiang
 */
public class FindRedundantDirectedConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int size = edges.length;
        UnionFind uf = new UnionFind(size + 1);
        int[] parent = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
        }
        // 同个父节点
        int cf = -1;
        int cyc = -1;
        for (int i = 0; i < size; i++) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if (parent[node2] != node2) {
                cf = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cyc = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }

        if (cf < 0) {
            return new int[]{edges[cyc][0], edges[cyc][1]};
        } else {
            int[] cfEdge = edges[cf];
            if (cyc >= 0) {
                return new int[]{parent[cfEdge[1]], cfEdge[1]};
            } else {
                return new int[]{cfEdge[0], cfEdge[1]};
            }
        }
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
