package leetcode.days;

import leetcode.struct.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author god-jiang
 * @date 2020/11/24 21:12
 */
public class CountNodes {
    int count = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            ++count;
            dfs(root.right);
        }
    }
}
