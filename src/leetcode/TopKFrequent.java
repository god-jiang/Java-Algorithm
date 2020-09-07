package leetcode;

import java.util.*;

/**
 * LeetCode347，前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前K高的元素。
 * author:god-jiang
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // nums为空，直接返回
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // 建立大根堆
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (Integer key : map.keySet()) {
            max.offer(key);
        }

        List<Integer> list = new ArrayList<>();
        while (k != 0) {
            list.add(max.poll());
            k--;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
