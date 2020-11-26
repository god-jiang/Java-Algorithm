package leetcode.days;

import java.util.Arrays;

/**
 * 164. 最大间距
 *
 * @author god-jiang
 * @date 2020/11/26 22:36
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(Math.abs(nums[i] - nums[i - 1]), max);
        }
        return max;
    }
}
