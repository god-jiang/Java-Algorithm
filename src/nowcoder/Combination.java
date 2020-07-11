package nowcoder;

import java.util.Arrays;

/**
 * @author god-jiang
 * @date 2020/3/19  19:57
 */
public class Combination {
    public static void dfs(char[] input, char[] output, int index, int start) {
        if (index == output.length) {
            System.out.println(Arrays.toString(output));
        } else {
            for (int j = start; j < input.length; j++) {
                output[index] = input[j];
                dfs(input, output, index + 1, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        char[] input = "abc".toCharArray();
        //N表示组合中取几位数
        int N = 2;
        char[] output = new char[N];
        dfs(input, output, 0, 0);
    }
}
