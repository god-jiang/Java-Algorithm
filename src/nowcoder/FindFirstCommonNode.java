package nowcoder;

/**
 * @author god-jiang
 * @date 2020/2/9  21:02
 */
public class FindFirstCommonNode {
    //链表的定义
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        //计算出链表pHead1和pHead2的长度
        while (node1 != null) {
            length1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            length2++;
            node2 = node2.next;
        }
        //让长的链表先走N步（N=Math.abs(length1-length2)）
        if (length1 > length2) {
            int go = length1 - length2;
            while (go > 0) {
                go--;
                pHead1 = pHead1.next;
            }
        } else {
            int go = length2 - length1;
            while (go > 0) {
                go--;
                pHead2 = pHead2.next;
            }
        }
        //同时走，只要有公共结点就会遇到，没有公共结点就返回null
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
