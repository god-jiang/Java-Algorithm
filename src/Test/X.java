package Test;

import java.util.HashMap;

/**
 * @author god-jiang
 * @date 2020/1/14  16:17
 */
public class X {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(str.charAt(i))) {
                int val = map.get(str.charAt(i));
                map.remove(str.charAt(i));
                map.put(str.charAt(i), val + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = "abcXYZdef";
        String s1 = str.substring(3, str.length());
        String s2 = str.substring(0, 3);
        System.out.println(s1+s2);
    }
}
