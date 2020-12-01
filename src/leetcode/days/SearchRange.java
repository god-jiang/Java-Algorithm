package leetcode.days;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author god-jiang
 * @date 2020/12/1 19:54
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int star = binSearch(nums, 0, nums.length - 1, target, true);
        int end = binSearch(nums, 0, nums.length - 1, target, false) - 1;
        if (star <= end && end < nums.length) {
            return new int[]{star, end};
        }
        return new int[]{-1, -1};
    }

    public int binSearch(int[] nums, int left, int right, int target, boolean flag) {

        int res = nums.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
