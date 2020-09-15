package leetcode;

/**
 * leetcode60，第K个排列
 *
 * @author god-jiang
 */
public class GetPermutation {
    /**
     * 数学归纳法
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] res = new int[n + 1];
        boolean[] flag = new boolean[n + 1];
        res[0] = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!flag[j]) {
                    if (k <= res[n - i]) {
                        flag[j] = true;
                        sb.append(j);
                        break;
                    }
                }
                k -= res[n - i];
            }
        }
        return sb.toString();
    }
}
