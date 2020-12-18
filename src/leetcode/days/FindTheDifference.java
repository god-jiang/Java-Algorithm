package leetcode.days;

import java.util.*;

/**
 * 389. 找不同
 *
 * @author god-jiang
 * @date 2020/12/18 20:52
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : t.toCharArray()) {
            int temp = map.getOrDefault(ch, 0) - 1;
            if (temp < 0) {
                return ch;
            }
            map.put(ch, temp);
        }
        return ' ';
    }
}
