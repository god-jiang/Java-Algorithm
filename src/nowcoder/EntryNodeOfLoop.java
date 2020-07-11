package nowcoder;

/**
 * @author god-jiang
 * @date 2020/1/21  0:40
 */
public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //定义快慢指针
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //如果有环，想遇于环中某点
            if (fast == slow) {
                break;
            }
        }
        //如果没有环，return null
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        //如果有环，两个指针分别从链表头和相遇点出发，最终必定在环入口相遇
        slow = pHead;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
