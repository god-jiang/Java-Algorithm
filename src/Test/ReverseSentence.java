package Test;

import java.util.Stack;

/**
 * @author god-jiang
 * @date 2020/1/19  18:40
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String str = " ";
        Stack<String> stack = new Stack<>();
        String[] split = str.split(" ");
        if(split==null||split.length==0){
            return ;
        }
        for (String s : split
        ) {
            stack.push(s);
        }
        String res = "";
        while (stack.size() != 1) {
            res = res + stack.pop() + " ";
        }
        res += stack.pop();
        System.out.println(res);
    }
}
