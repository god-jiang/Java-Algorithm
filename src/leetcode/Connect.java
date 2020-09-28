package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode117，填充每个节点的下一个右侧节点指针二
 * 填充它的每个next指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将next指针设置为NULL。初始状态下，所有next指针都被设置为NULL。
 * @author god-jiang
 */
public class Connect {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i != 0) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
