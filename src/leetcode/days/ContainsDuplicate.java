package leetcode.days;

import java.util.*;

/**
 * 217. 存在重复元素
 *
 * @author god-jiang
 * @date 2020/12/13 21:32
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], temp);
            if (temp == 2) {
                return true;
            }
        }
        return false;
    }
}
