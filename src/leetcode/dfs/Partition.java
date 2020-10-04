package leetcode.dfs;

import java.util.*;

/**
 * 回溯算法131，分割回文串
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串
 *
 * @author god-jiang
 */
public class Partition {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int st) {
        if (st == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = st; i < s.length(); i++) {
            if (!check(s, st, i)) {
                // 剪枝
                continue;
            }
            list.add(s.substring(st, i + 1));
            dfs(s, i + 1);
            // 回溯
            list.remove(list.size() - 1);
        }
    }

    public boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
