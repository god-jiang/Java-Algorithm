package leetcode.days;

import java.util.*;

/**
 * leetcode844，比较含退格的字符串
 * 给定S和T两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，
 * 并返回结果。#代表退格字符。
 *
 * @author god-jiang
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return back(S).equals(back(T));
    }

    public String back(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
