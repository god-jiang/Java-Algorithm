package nowcoder;

import java.util.ArrayList;

/**
 * @author god-jiang
 * @date 2020/2/3  12:35
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //设置两个指针left和right
        int left = 1;
        int right = 2;
        while (left < right) {
            //因为都是连续的，差值为1的等差数列。
            //求和公式为(a0+an)*n/2
            int curSum = (left + right) * (right - left + 1) / 2;
            //判断curSum和sum的大小关系调整对应的left和right
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
                left++;
            } else if (curSum < sum) {
                right++;
            } else {
                left++;
            }
        }
        return res;
    }
}
