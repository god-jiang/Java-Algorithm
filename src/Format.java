import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @author god-jiang
 * @date 2020/1/1
 */
public class Format {
    public class Solution {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            //记录滑动窗口实时的最大值结果
            ArrayList<Integer> list = new ArrayList<>();
            //双向链表，从左到右必须是从大到小的顺序
            LinkedList<Integer> queue = new LinkedList<>();
            int length = num.length;
            if (length < size || size == 0) {
                return list;
            }
            for (int i = 0; i < length; i++) {
                //如果链表的尾部小于即将插入的值，则弹出
                while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                    queue.pollLast();
                }
                //插入只能从尾部插入
                queue.addLast(i);
                //判断链表的头节点是否过期，从头部弹出
                if (i - queue.peekFirst() == size) {
                    queue.pollFirst();
                }
                //当达到滑动窗口的size时，进行收集结果
                if (i >= size - 1) {
                    list.add(num[queue.peekFirst()]);
                }
            }
            return list;
        }
    }
}
