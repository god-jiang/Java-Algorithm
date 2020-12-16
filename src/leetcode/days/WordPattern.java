package leetcode.days;

import java.util.*;

/**
 * 290. 单词规律
 *
 * @author god-jiang
 * @date 2020/12/16 20:25
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if (pattern.length() != str.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (!map.containsValue(str[i])) {
                    map.put(ch, str[i]);
                } else {
                    return false;
                }
            } else if (!map.get(ch).equals(str[i])) {
                return false;
            }
        }
        return true;
    }
}
