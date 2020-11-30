package leetcode.days;

/**
 * 767. 重构字符串
 *
 * @author god-jiang
 * @date 2020/11/30 20:42
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        char[] arr = S.toCharArray();
        int[] count = new int[26];
        int max = 0;
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            count[arr[i] - 'a']++;
            if (count[arr[i] - 'a'] > max) {
                max = count[arr[i] - 'a'];
                index = arr[i] - 'a';
                if (max > (S.length() + 1) / 2) {
                    return "";
                }
            }
        }

        char[] res = new char[S.length()];
        int in = 0;
        while (count[index]-- > 0) {
            res[in] = (char) (index + 'a');
            in += 2;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                if (in >= res.length) {
                    in = 1;
                }
                res[in] = (char) (i + 'a');
                in += 2;
            }
        }

        return new String(res);
    }
}
