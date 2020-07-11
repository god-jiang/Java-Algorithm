package zuoshen;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/1/12  19:35
 */
public class Manacher {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String s="123";
        char[] chars = manacherString(s);
        System.out.println(Arrays.toString(chars));
    }
}
