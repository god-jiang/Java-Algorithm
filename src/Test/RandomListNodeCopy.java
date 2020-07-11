package Test;

import java.util.HashMap;

/**
 * @author god-jiang
 * @date 2020/1/16  18:48
 */
public class RandomListNodeCopy {
    //定义复杂链表的结构
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //用HashMap解决。时间复杂度O(N)，空间复杂度O(N)
/*    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }*/

    //合并拆分的时间复杂度为O(N)，空间复杂度为O(1)
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (cur != null) {
            RandomListNode cloneNode = new RandomListNode(cur.label);
            RandomListNode nextNode = cur.next;
            cur.next = cloneNode;
            cloneNode.next = nextNode;
            cur = nextNode;
        }

        cur = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur != null) {
            RandomListNode cloneNode = cur.next;
            cur.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            cur = cur.next;
        }

        return pCloneHead;
    }
}
