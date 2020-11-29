package leetcode.days;

import leetcode.struct.ListNode;

/**
 * 328. 奇偶链表
 *
 * @author god-jiang
 * @date 2020/11/29 21:22
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        // 分别定义奇偶链表的虚拟头节点和尾节点
        ListNode oddHead = new ListNode(0);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;

        // 遍历原链表，根据isOdd标示位决定将当前节点插入到奇链表还是偶链表
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        // 将奇链表后面拼接上偶链表，并将偶链表的next设置为null
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;
    }

}
