package leetcode.days;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 *
 * @author god-jiang
 * @date 2020/11/29 20:41
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i <= A.length - 2; i++) {
            max = Math.max(max, count(A[i], A[i + 1], A[i + 2]));
        }
        return max;
    }

    /**
     * 计算出三角形的周长
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int count(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return a + b + c;
        }
        return 0;
    }
}
