package leetcode.days;

import java.util.*;

/**
 * leetcode1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * @author god-jiang
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], temp);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            set.add(key.getValue());
        }
        return set.size() == map.size();
    }
}
