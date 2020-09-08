package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode77，组合
 * 给定两个整数n和k，返回1...n中所有可能的k个数的组合。
 * @author god-jiang
 */
public class Combine {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] input = new int[n];
        for (int i = 1; i <= n; i++) {
            input[i - 1] = i;
        }
        int[] output = new int[k];
        dfs(input, output, 0, 0);
        return result;
    }

    public void dfs(int[] input, int[] output, int index, int start) {
        if (index == output.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < output.length; i++) {
                list.add(output[i]);
            }
            result.add(list);
        } else {
            for (int i = start; i < input.length; i++) {
                output[index] = input[i];
                dfs(input, output, index + 1, i + 1);
            }
        }
    }
}
