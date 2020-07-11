import java.util.Stack;

/**
 * @author god-jiang
 * @date 2020/1/8
 */
public class MaximalRectangle {
    /**
     * 给定一个数组[4,3,2,5,6]，每一个数代表一个矩形的高度，组成的一个二维数组，求其中的最大矩形
     * 解法，用最大单调栈的结构来求解，用来求解一个连续的无规则面积中最大的矩形面积
     *
     * @return
     */
    public static int maxRecFromBottom(int[] height) {
        int maxArea = 0;
        if (height.length <= 0)
            return 0;
        //从小到大的单调栈
        Stack<Integer> stack = new Stack<>();
        //这一步是在求每次遇到不是单调递增的时候那个柱子的面积
        for (int i = 0; i < height.length; i++) {
            //如果栈不为空，且当前元素小于栈顶元素
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                //左边界
                int k = stack.isEmpty() ? -1 : stack.peek();
                //(右边界 - 左边界)*高度
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        //求整个单调递增的面积
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            //当前的右边界就是数组长度
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static int maxRecSize(int[][] map) {
        int maxArea = 0;
        if (map.length <= 0)
            return 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                //如果当前行不是0，则累加高度
                if (map[i][j] != 0)
                    height[j] += map[i][j];
                else//如果当前行的值为0，则高度为0
                    height[j] = 0;
            }
            //求出每一行的最大矩形面积
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }

        return maxArea;
    }
}
