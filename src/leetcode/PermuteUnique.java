package leetcode;

import java.util.*;

/**
 * leetcode47，全排列二
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @author god-jiang
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = null;
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0, nums.length);
        for (List<Integer> key : set) {
            res.add(key);
        }
        return res;
    }

    public void dfs(int[] nums, int st, int len) {
        if (st == len - 1) {
            list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);
            }
            set.add(list);
        } else {
            for (int i = st; i < len; i++) {
                swap(nums, st, i);
                dfs(nums, st + 1, len);
                swap(nums, st, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
