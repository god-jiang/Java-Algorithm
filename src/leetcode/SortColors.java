package leetcode;

/**
 * leetcode75，颜色分类
 * 给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。此题中，我们使用整数0、1、2分别表示红色、白色和蓝色。
 *
 * @author god-jiang
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int cur = 0;
        int less = -1;
        int more = n;
        while (cur < more) {
            if (nums[cur] < 1) {
                swap(nums, ++less, cur++);
            } else if (nums[cur] > 1) {
                swap(nums, --more, cur);
            } else {
                cur++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
