package leetcode.days;

import java.util.Arrays;

/**
 * 5603. 确定两个字符串是否接近
 *
 * @author god-jiang
 * @date 2020/11/15 22:03
 */
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 != length2) {
            return false;
        }
        int[] p1 = new int[26];
        for (Character c : word1.toCharArray()) {
            p1[c - 'a']++;
        }

        int[] p2 = new int[26];
        for (Character c : word2.toCharArray()) {
            p2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (p1[i] > 0 && p2[i] == 0) {
                return false;
            }
            if (p1[i] == 0 && p2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(p1);
        Arrays.sort(p2);
        for (int i = 0; i < 26; i++) {
            if (p1[i] != p2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] p = new int[]{4, 2, 5, 1, 6};
        Arrays.sort(p);
        System.out.println(p);
    }
}
