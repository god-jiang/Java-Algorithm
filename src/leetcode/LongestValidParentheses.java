package leetcode;

import java.util.Stack;

/**
 * @author god-jiang
 * @date 2020/1/29  17:59
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果匹配到左括号就直接进栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 右括号出栈，并且判断栈是否为空，
                // 如果为空，把当前下标进栈，
                // 如果不为空，计算出当前有效的长度，记录下来
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
