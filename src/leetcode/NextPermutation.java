package leetcode;

/**
 * leetcode31，下一个排列
 *
 * @author god-jiang
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int k = n - 1;
                while (i < k && nums[k] <= nums[i]) {
                    k--;
                }
                swap(nums, i, k);
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    swap(nums, left++, right--);
                }
                return;
            }
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
