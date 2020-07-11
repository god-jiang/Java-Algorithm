package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author god-jiang
 * @date 2020/1/29  15:01
 */
public class StackIsValid {

    public static boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //如果是开括号
            if (!map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                //如果是闭括号
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="()";
        System.out.println(isValid(s));
    }
}
