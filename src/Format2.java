import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author god-jiang
 * @date 2020/1/3
 */
public class Format2 {
    PriorityQueue<Integer> min = null;
    PriorityQueue<Integer> max = null;
    /**
     * initialize your data structure here.
     */
    public Format2() {
        //默认从小到大排序
        min = new PriorityQueue<>();
        //修改比较器，让他从大到小排序
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        //进来一个树先判断是不是小于大根堆堆顶，是就放大根堆，不是放小根堆
        if (max.size() == 0 || max.peek() > num) {
            max.add(num);
        } else {
            min.add(num);
        }
        //保证两个堆的个数相差不大于1
        if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        int count = max.size() + min.size();
        //判断总的个数是否为偶数
        if ((count & 1) == 0) {
            return (max.peek() + min.peek()) / 2.0;
        }
        //总的个数是奇数的情况
        if (max.size() > min.size()) {
            return max.peek() / 1.0;
        }
        return min.peek() / 1.0;
    }
}
