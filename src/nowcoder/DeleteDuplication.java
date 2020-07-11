package nowcoder;

/**
 * @author god-jiang
 * @date 2020/2/5  14:33
 */
public class DeleteDuplication {
    //链表定义
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //递归解法
/*    public ListNode deleteDuplication(ListNode pHead) {
        //base case
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;
        ListNode cur;
        //对重复结点的处理
        if (pHead.val == pHead.next.val) {
            cur = pHead.next.next;
            //遍历到没有重复结点的位置
            while (cur != null && cur.val == pHead.val) {
                cur = cur.next;
            }
            return deleteDuplication(cur);
        }
        //没有重复结点
        cur = pHead.next;
        pHead.next = deleteDuplication(cur);
        return pHead;
    }*/

    //非递归解法
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //初始化一个0为头结点，防止pHead的第一个结点和第二个结点相同的情况
        ListNode head = new ListNode(0);
        head.next = pHead;
        //pre指向确定不重复的结点
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            //如果last和后面的指针相同
            if (last.next != null && last.val == last.next.val) {
                //找到last往后不重复的结点的位置
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                //相当于删除重复的结点
                pre.next = last.next;
                last = last.next;
            } else {
                //如果不重复，pre和last分别往后移动
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }

}
