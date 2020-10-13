package leetcode;

import leetcode.struct.ListNode;

/**
 * leetcode24，两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * @author god-jiang
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode p1 = temp.next;
            ListNode p2 = temp.next.next;
            temp.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            temp = p1;
        }
        return dummy.next;
    }
}
