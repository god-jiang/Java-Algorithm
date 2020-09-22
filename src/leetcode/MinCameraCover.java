package leetcode;

/**
 * leetcode968，监控二叉树
 * @author god-jiang
 */
public class MinCameraCover {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            res++;
        }
        return res;
    }

    /**
     * dfs返回节点的状态
     * 0:未被摄像头照到（覆盖）
     * 1：被摄像头照到（覆盖）
     * 2：放置了摄像头
     */
    public int dfs(TreeNode root) {
        //为了保证摄像头数目最小，叶子节点不能放置摄像头，所以root为null时，设置其状态是已覆盖。
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //左右孩子一共有00 01 02 11 12 22这些状态

        //00 01 02，左右孩子只要有一个未被覆盖，root就需要放置摄像头
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }

        //11，root需要被父节点的摄像头覆盖，设置为0
        if (left == 1 && right == 1) {
            return 0;
        }
        //12,22 ,roo被儿子覆盖，设置为1
        if (left + right >= 3) {
            return 1;
        }

        // 所有的状态都已经被包含，随便返回一个值
        return 0;
    }
}
