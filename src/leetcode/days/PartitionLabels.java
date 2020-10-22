package leetcode.days;

import java.util.*;

/**
 * leetcode763，划分字母区间
 * 字符串S由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * @author god-jiang
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int st = 0;
        int end = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - st + 1);
                st = end + 1;
            }
        }
        return list;
    }
}
