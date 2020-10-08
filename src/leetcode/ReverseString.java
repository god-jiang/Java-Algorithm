package leetcode;

/**
 * leetcode344，反转字符串
 * 必须原地修改输入数组、使用O(1)的额外空间解决这一问题
 *
 * @author god-jiang
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
