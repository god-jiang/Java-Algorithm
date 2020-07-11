package nowcoder;


import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/1/13  20:52
 */
public class ReConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //已知前序遍历和中序遍历，重建二叉树并返回
    //前序：{1,2,4,7,3,5,6,8}
    //中序：{4,7,2,1,5,3,8,6}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        //找出根
        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                node.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                node.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return node;
    }
}
