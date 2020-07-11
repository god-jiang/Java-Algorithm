package leetcode;

/**
 * @author god-jiang
 * @date 2020/2/13  21:21
 */
public class ReverseKGroup {
    //定义链表
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //dummy是虚拟节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    //反转链表并返回头节点
    public ListNode reverse(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
        return head;
    }
}
