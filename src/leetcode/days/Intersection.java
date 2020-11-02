package leetcode.days;


import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author god-jiang
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums2[i] == nums1[j]) {
                    set.add(nums1[j]);
                }
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer in : set) {
            res[index++] = in;
        }
        return res;
    }
}
