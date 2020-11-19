package leetcode.days;

/**
 * 283. 移动零
 *
 * @author god-jiang
 * @date 2020/11/19 22:04
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
