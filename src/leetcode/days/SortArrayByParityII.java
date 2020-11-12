package leetcode.days;

/**
 * leetcode922. 按奇偶排序数组 II
 *
 * @author god-jiang
 * @date 2020/11/12 21:49
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];

        int index = 0;
        for (int x : A) {
            if ((x & 1) == 0) {
                res[index] = x;
                index += 2;
            }
        }

        index = 1;
        for (int x : A) {
            if ((x & 1) == 1) {
                res[index] = x;
                index += 2;
            }
        }

        return res;
    }
}
