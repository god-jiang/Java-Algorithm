package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode39，组合总和
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * @author god-jiang
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, result, combine, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, result, combine, index + 1);
        // 选择当前数
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], result, combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
