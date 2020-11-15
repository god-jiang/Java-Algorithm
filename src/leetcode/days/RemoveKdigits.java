package leetcode.days;

import java.util.Stack;

/**
 * 402. 移掉K位数字
 *
 * @author god-jiang
 * @date 2020/11/15 22:17
 */
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String rever = rever(sb.toString());

        boolean isZero = true;
        String str = "";
        for (int i = 0; i < rever.length(); i++) {
            if (isZero && sb.charAt(i) == '0') {
                continue;
            }
            isZero = false;
            str += sb.charAt(i);
        }
        return str.length() == 0 ? "0" : str;
    }

    public static String rever(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        removeKdigits("10200", 1);
    }
}
