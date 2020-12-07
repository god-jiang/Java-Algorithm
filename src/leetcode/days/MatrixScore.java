package leetcode.days;

/**
 * 861. 翻转矩阵后的得分
 *
 * @author god-jiang
 * @date 2020/12/7 21:27
 */
public class MatrixScore {
    public int matrixScore(int[][] A) {
        // 把第一列全部变为1
        for (int[] a : A) {
            if (a[0] == 0) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = a[i] == 0 ? 1 : 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) {
                    count++;
                }
            }
            if (count <= A.length / 2) {
                count = A.length - count;
            }
            res += count * Math.pow(2, A[0].length - i - 1);
        }

        return res;
    }
}
