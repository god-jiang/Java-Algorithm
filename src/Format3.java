import java.util.Stack;

/**
 * @author god-jiang
 * @date 2020/1/6
 */
public class Format3 {
    //正常stack
    Stack<Integer> stack = new Stack<>();
    //存放min的stack
    Stack<Integer> help = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (help.isEmpty()) {
            help.push(node);
        } else {
            //help里面存放的都是最小值,也就是pop之后里面是当前的最小值
            int res = help.peek() > node ? node : help.peek();
            help.push(res);
        }
    }

    public void pop() {
        stack.pop();
        help.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return help.peek();
    }
}
