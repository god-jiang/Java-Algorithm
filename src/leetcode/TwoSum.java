package leetcode;

import java.util.HashMap;

/**
 * @author god-jiang
 * @date 2020/1/24  18:39
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.size() > 0 && map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
