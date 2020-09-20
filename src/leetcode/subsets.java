package leetcode;

import java.util.*;

/**
 * leetcode78，子集
 *
 * @author god-jiang
 */
public class subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int[] output = new int[i];
            dfs(nums, output, 0, 0);
        }
        res.add(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        res.add(list);
        return res;
    }

    /**
     * 组合算法模版
     * @param input
     * @param output
     * @param index
     * @param start
     */
    public void dfs(int[] input, int[] output, int index, int start) {
        if (index == output.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < output.length; i++) {
                list.add(output[i]);
            }
            res.add(list);
        } else {
            for (int j = start; j < input.length; j++) {
                output[index] = input[j];
                dfs(input, output, index + 1, j + 1);
            }
        }
    }
}
