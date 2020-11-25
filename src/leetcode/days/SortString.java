package leetcode.days;

/**
 * 1370. 上升下降字符串
 *
 * @author god-jiang
 * @date 2020/11/25 20:42
 */
public class SortString {
    public String sortString(String s) {
        int[] arr = new int[26];
        for (Character c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }
}
