package leetcode.dfs;

/**
 * 回溯算法357，计算各个位数不同的数字个数
 *
 * @author god-jiang
 */
public class CountNumbersWithUniqueDigits {
    int count = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        countNumbersWithUniqueDigits(nums, n, 0);
        // 最后加上0这个数
        return count + 1;
    }

    int[] tag = new int[10];

    public void countNumbersWithUniqueDigits(int[] nums, int n, int st) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (st != i && tag[i] == 0) {
                tag[i] = 1;
                count++;
                countNumbersWithUniqueDigits(nums, n - 1, i);
                tag[i] = 0;
            }
        }
    }
}
