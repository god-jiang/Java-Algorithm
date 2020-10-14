package leetcode.days;

import java.util.*;

/**
 * leetcode1002，查找常用字符
 * 给定仅有小写字母组成的字符串数组A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现了3次，但不是4次，则需要在最终答案中包含该字符3次。
 *
 * @author god-jiang
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (Character c : A[i].toCharArray()) {
                if (map.containsKey(c)) {
                    map2.put(c, Math.min(map2.getOrDefault(c, 0) + 1, map.get(c)));
                }
            }
            map = map2;
        }

        List<String> list = new ArrayList<>();
        for (Character c : map.keySet()) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                list.add(String.valueOf(c));
            }
        }
        return list;
    }
}
